package com.art2cat.dev.concert.javaconfig;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncoreableIntroducer {

    @DeclareParents(value = "com.art2cat.dev.concert.IPerformance", defaultImpl = DefaultEncoreable.class)
    public static com.art2cat.dev.concert.IEncoreable IEncoreable;
}
