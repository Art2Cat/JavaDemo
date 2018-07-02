package com.art2cat.dev.iterator;

import com.art2cat.dev.abstractfactory.factory.impl.AbstractFactory;
import com.art2cat.dev.abstractfactory.factory.intf.IFactory;
import com.art2cat.dev.abstractfactory.factory.intf.ILink;
import com.art2cat.dev.abstractfactory.factory.intf.IPage;
import com.art2cat.dev.abstractfactory.factory.intf.ITray;
import java.io.IOException;
import org.junit.Test;

/**
 * com.art2cat.dev.iterator
 *
 * @author art2c
 * @date 5/25/2018
 */
public class AbstractFactoryTest {
    
    
    public void generateHtml(IFactory factory, String title) throws IOException {
        ILink google = factory.createLink("Google", "https://www.google.com");
        ILink twitter = factory.createLink("Twitter", "https://www.twitter.com");
        ILink facebook = factory.createLink("Facebook", "https://www.facebook.com");
        ILink yahoo = factory.createLink("Yahoo", "https://www.yahoo.co.jp");
        ILink yahooUS = factory.createLink("Yahoo", "https://www.yahoo.com");
        ILink excite = factory.createLink("Excite", "https://www.excite.com");
        ILink bing = factory.createLink("Bing", "https://www.bing.com");
        
        ITray trayYahoo = factory.createTray("Yahoo!");
        trayYahoo.add(yahoo);
        trayYahoo.add(yahooUS);
        
        ITray traySocial = factory.createTray("Social Media");
        traySocial.add(facebook);
        traySocial.add(twitter);
        
        ITray traySearch = factory.createTray("Search");
        traySearch.add(google);
        traySearch.add(trayYahoo);
        traySearch.add(bing);
        traySearch.add(excite);
        
        IPage page = factory.createPage(title, "Rorschach.H");
        page.add(traySearch);
        page.add(traySocial);
        page.output();
    }
    
    @Test
    public void test() throws IOException {
        IFactory factory = AbstractFactory
            .getFactory("com.art2cat.dev.abstract_factory.listfactory.ListFactory");
        generateHtml(factory, "LinkPage");
    }
    
    @Test
    public void testTableFactory() throws IOException {
        IFactory factory = AbstractFactory.getFactory("com.art2cat.dev.abstract_factory.tablefactory.TableFactory");
        generateHtml(factory, "TablePage");
    }
    
}
