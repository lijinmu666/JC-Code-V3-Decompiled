package org.bouncycastle.p228i18n;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;

/* loaded from: classes2.dex */
public class MissingEntryException extends RuntimeException {
    private String debugMsg;

    /* renamed from: key */
    protected final String f21228key;

    /* renamed from: loader */
    protected final ClassLoader f21229loader;

    /* renamed from: locale */
    protected final Locale f21230locale;
    protected final String resource;

    public MissingEntryException(String str, String str2, String str3, Locale locale, ClassLoader classLoader) {
        super(str);
        this.resource = str2;
        this.f21228key = str3;
        this.f21230locale = locale;
        this.f21229loader = classLoader;
    }

    public ClassLoader getClassLoader() {
        return this.f21229loader;
    }

    public String getDebugMsg() {
        if (this.debugMsg == null) {
            this.debugMsg = "Can not find entry " + this.f21228key + " in resource file " + this.resource + " for the locale " + this.f21230locale + ".";
            ClassLoader classLoader = this.f21229loader;
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
    public String m15984getKey() {
        return this.f21228key;
    }

    public Locale getLocale() {
        return this.f21230locale;
    }

    public String getResource() {
        return this.resource;
    }

    public MissingEntryException(String str, Throwable th, String str2, String str3, Locale locale, ClassLoader classLoader) {
        super(str, th);
        this.resource = str2;
        this.f21228key = str3;
        this.f21230locale = locale;
        this.f21229loader = classLoader;
    }
}
