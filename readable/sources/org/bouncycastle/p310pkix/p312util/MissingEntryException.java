package org.bouncycastle.p310pkix.p312util;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;

/* loaded from: classes2.dex */
public class MissingEntryException extends RuntimeException {
    private String debugMsg;

    /* renamed from: key */
    protected final String f23002key;

    /* renamed from: loader */
    protected final ClassLoader f23003loader;

    /* renamed from: locale */
    protected final Locale f23004locale;
    protected final String resource;

    public MissingEntryException(String str, String str2, String str3, Locale locale, ClassLoader classLoader) {
        super(str);
        this.resource = str2;
        this.f23002key = str3;
        this.f23004locale = locale;
        this.f23003loader = classLoader;
    }

    public ClassLoader getClassLoader() {
        return this.f23003loader;
    }

    public String getDebugMsg() {
        if (this.debugMsg == null) {
            this.debugMsg = "Can not find entry " + this.f23002key + " in resource file " + this.resource + " for the locale " + this.f23004locale + ".";
            ClassLoader classLoader = this.f23003loader;
            if (classLoader instanceof URLClassLoader) {
                URL[] uRLs = ((URLClassLoader) classLoader).getURLs();
                this.debugMsg += " The following entries in the classpath were searched: ";
                for (int i = 0; i != uRLs.length; i++) {
                    this.debugMsg += uRLs[i] + " ";
                }
            }
        }
        return this.debugMsg;
    }

    /* renamed from: getKey */
    public String m17453getKey() {
        return this.f23002key;
    }

    public Locale getLocale() {
        return this.f23004locale;
    }

    public String getResource() {
        return this.resource;
    }

    public MissingEntryException(String str, Throwable th, String str2, String str3, Locale locale, ClassLoader classLoader) {
        super(str, th);
        this.resource = str2;
        this.f23002key = str3;
        this.f23004locale = locale;
        this.f23003loader = classLoader;
    }
}
