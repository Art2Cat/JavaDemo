package com.art2cat.dev.concurrency.concurrency_in_practice.thread_safety;

import java.math.BigInteger;
import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * SynchronizedFactorizer
 *
 * Servlet that caches last result, but with unnacceptably poor concurrency Negative
 *
 * @author Brian Goetz and Tim Peierls
 */


public class SynchronizedFactorizer extends GenericServlet implements Servlet {


    private BigInteger lastNumber;

    private BigInteger[] lastFactors;

    @Override
    public synchronized void service(ServletRequest req,
        ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        if (i.equals(lastNumber)) {
            encodeIntoResponse(resp, lastFactors);
        } else {
            BigInteger[] factors = factor(i);
            lastNumber = i;
            lastFactors = factors;
            encodeIntoResponse(resp, factors);
        }
    }

    void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[]{i};
    }
}

