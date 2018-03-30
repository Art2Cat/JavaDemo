/**
 * Copyright (c) 2003-2006, Joe Walnes Copyright (c) 2006-2007, XStream Committers All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following
 * disclaimer. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the
 * following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * Neither the name of XStream nor the names of its contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 **/
package com.thoughtworks.xstream.mapper;

import com.art2cat.dev.model.intf.ICustomEnum;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mapper that allows a fully qualified class name to be replaced with a shorter alias.
 *
 * @author Joe Walnes
 */
@SuppressWarnings("unchecked")
public class ClassAliasingMapper extends MapperWrapper {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassAliasingMapper.class.getName());
    protected final Map typeToName = new HashMap();
    protected final Map classToName = new HashMap();
    protected final Set knownAttributes = new HashSet();
    protected final Map<String, String> customMappings = new HashMap<>();
    protected transient Map nameToType = new HashMap();
    
    /**
     *
     * @param wrapped
     */
    public ClassAliasingMapper(Mapper wrapped) {
        super(wrapped);
        
        customMappings.put("com.art2cat.dev.model.Country", "com.art2cat.dev.model.CountryEnum");
        
        
    }
    
    /**
     *
     * @param name
     * @param type
     */
    public void addClassAlias(String name, Class type) {
        nameToType.put(name, type.getName());
        classToName.put(type.getName(), name);
    }
    
    /**
     *
     * @param name
     * @param type
     */
    public void addClassAttributeAlias(String name, Class type) {
        addClassAlias(name, type);
        knownAttributes.add(name);
    }
    
    /**
     *
     * @param name
     * @param type
     */
    public void addTypeAlias(String name, Class type) {
        nameToType.put(name, type.getName());
        typeToName.put(type, name);
    }
    
    /**
     *
     * @param type
     * @return
     */
    @Override
    public String serializedClass(Class type) {
        
        // if the class is a service
        // use the name of the service as an alias
        if (ICustomEnum.class.isAssignableFrom(type)) {
            return type.getName();
        } else if (Enum.class.isAssignableFrom(type)) {
            return type.getName();
        }
        
        // Usual XStream code in any other case.
        String alias = (String) classToName.get(type.getName());
        if (alias != null) {
            return alias;
        } else {
            for (final Iterator iter = typeToName.keySet().iterator(); iter.hasNext(); ) {
                final Class compatibleType = (Class) iter.next();
                if (compatibleType.isAssignableFrom(type)) {
                    return (String) typeToName.get(compatibleType);
                }
            }
            return super.serializedClass(type);
        }
    }
    
    /**
     *
     * @param elementName
     * @return
     */
    @Override
    public Class realClass(String elementName) {
        
        // check custom converted plugin types
        if (customMappings.containsKey(elementName)) {
            String oldName = elementName;
            elementName = customMappings.get(oldName);
            LOGGER.info("--- Changed elementName FROM [{}] TO [{}] ", oldName, elementName);
        }
        
        // If it failed, back to the normal XStream code.
        String mappedName = (String) nameToType.get(elementName);
        if (mappedName != null) {
            Class type = primitiveClassNamed(mappedName);
            if (type != null) {
                return type;
            }
            elementName = mappedName;
        }
        
        return super.realClass(elementName);
    }
    
    /**
     *
     * @param clazz
     * @return
     */
    public boolean itemTypeAsAttribute(Class clazz) {
        return classToName.containsKey(clazz);
    }
    
    /**
     *
     * @param name
     * @return
     */
    public boolean aliasIsAttribute(String name) {
        return nameToType.containsKey(name);
    }
    
    private Object readResolve() {
        nameToType = new HashMap();
        for (final Iterator iter = classToName.keySet().iterator(); iter.hasNext(); ) {
            final Object type = iter.next();
            nameToType.put(classToName.get(type), type);
        }
        for (final Iterator iter = typeToName.keySet().iterator(); iter.hasNext(); ) {
            final Class type = (Class) iter.next();
            nameToType.put(typeToName.get(type), type.getName());
        }
        return this;
    }
    
    private Class primitiveClassNamed(String name) {
        return name.equals("void") ? Void.TYPE
            : name.equals("boolean") ? Boolean.TYPE
                : name.equals("byte") ? Byte.TYPE
                    : name.equals("char") ? Character.TYPE
                        : name.equals("short") ? Short.TYPE
                            : name.equals("int") ? Integer.TYPE
                                : name.equals("long") ? Long.TYPE
                                    : name.equals("float") ? Float.TYPE
                                        : name.equals("double") ? Double.TYPE
                                            : null;
    }
    
}
