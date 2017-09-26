package com.art2cat.dev.restful;

import com.art2cat.dev.restful.utils.AESUtils;
import org.junit.Test;

public class AESUtilsTest {
    @Test
    public void testDecrypt() {
        String key = AESUtils.generateKey();
        System.out.println(key);
        String encrypt = AESUtils.encrypt(key, "Fuck you");
        System.out.println(encrypt);
        System.out.println(AESUtils.decrypt(key, encrypt));
    }
}
