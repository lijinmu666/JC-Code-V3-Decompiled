package org.bouncycastle.p228i18n;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.TimeZone;
import org.bouncycastle.p228i18n.p229filter.InterfaceC5449Filter;
import org.bouncycastle.p228i18n.p229filter.TrustedInput;
import org.bouncycastle.p228i18n.p229filter.UntrustedInput;
import org.bouncycastle.p228i18n.p229filter.UntrustedUrlInput;

/* loaded from: classes2.dex */
public class LocalizedMessage {
    public static final String DEFAULT_ENCODING = "ISO-8859-1";
    protected FilteredArguments arguments;
    protected String encoding;
    protected FilteredArguments extraArgs;

    /* renamed from: filter */
    protected InterfaceC5449Filter f21223filter;

    /* renamed from: id */
    protected final String f21224id;

    /* renamed from: loader */
    protected ClassLoader f21225loader;
    protected final String resource;

    public static class FilteredArguments {

        /* renamed from: FILTER */
        protected static final int f21226FILTER = 1;
        protected static final int FILTER_URL = 2;
        protected static final int NO_FILTER = 0;
        protected int[] argFilterType;
        protected Object[] arguments;

        /* renamed from: filter */
        protected InterfaceC5449Filter f21227filter;
        protected Object[] filteredArgs;
        protected boolean[] isLocaleSpecific;
        protected Object[] unpackedArgs;

        public FilteredArguments() {
            this(new Object[0]);
        }

        /* renamed from: filter */
        private Object m15982filter(int i, Object obj) {
            InterfaceC5449Filter interfaceC5449Filter = this.f21227filter;
            if (interfaceC5449Filter != null) {
                if (obj == null) {
                    obj = "null";
                }
                if (i != 0) {
                    if (i == 1) {
                        return interfaceC5449Filter.doFilter(obj.toString());
                    }
                    if (i != 2) {
                        return null;
                    }
                    return interfaceC5449Filter.doFilterUrl(obj.toString());
                }
            }
            return obj;
        }

        public Object[] getArguments() {
            return this.arguments;
        }

        public InterfaceC5449Filter getFilter() {
            return this.f21227filter;
        }

        public Object[] getFilteredArgs(Locale locale) {
            Object[] objArr = new Object[this.unpackedArgs.length];
            int i = 0;
            while (true) {
                Object[] objArr2 = this.unpackedArgs;
                if (i >= objArr2.length) {
                    return objArr;
                }
                Object objM15982filter = this.filteredArgs[i];
                if (objM15982filter == null) {
                    Object obj = objArr2[i];
                    if (this.isLocaleSpecific[i]) {
                        objM15982filter = m15982filter(this.argFilterType[i], ((LocaleString) obj).getLocaleString(locale));
                    } else {
                        objM15982filter = m15982filter(this.argFilterType[i], obj);
                        this.filteredArgs[i] = objM15982filter;
                    }
                }
                objArr[i] = objM15982filter;
                i++;
            }
        }

        /* renamed from: isEmpty */
        public boolean m15983isEmpty() {
            return this.unpackedArgs.length == 0;
        }

        public void setFilter(InterfaceC5449Filter interfaceC5449Filter) {
            if (interfaceC5449Filter != this.f21227filter) {
                for (int i = 0; i < this.unpackedArgs.length; i++) {
                    this.filteredArgs[i] = null;
                }
            }
            this.f21227filter = interfaceC5449Filter;
        }

        public FilteredArguments(Object[] objArr) {
            this.f21227filter = null;
            this.arguments = objArr;
            this.unpackedArgs = new Object[objArr.length];
            this.filteredArgs = new Object[objArr.length];
            this.isLocaleSpecific = new boolean[objArr.length];
            this.argFilterType = new int[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                Object obj = objArr[i];
                if (obj instanceof TrustedInput) {
                    this.unpackedArgs[i] = ((TrustedInput) obj).getInput();
                    this.argFilterType[i] = 0;
                } else if (obj instanceof UntrustedInput) {
                    this.unpackedArgs[i] = ((UntrustedInput) obj).getInput();
                    if (objArr[i] instanceof UntrustedUrlInput) {
                        this.argFilterType[i] = 2;
                    } else {
                        this.argFilterType[i] = 1;
                    }
                } else {
                    this.unpackedArgs[i] = obj;
                    this.argFilterType[i] = 1;
                }
                this.isLocaleSpecific[i] = this.unpackedArgs[i] instanceof LocaleString;
            }
        }
    }

    public LocalizedMessage(String str, String str2) {
        this.encoding = "ISO-8859-1";
        this.extraArgs = null;
        this.f21223filter = null;
        this.f21225loader = null;
        if (str == null || str2 == null) {
            throw null;
        }
        this.f21224id = str2;
        this.resource = str;
        this.arguments = new FilteredArguments();
    }

    public String addExtraArgs(String str, Locale locale) {
        if (this.extraArgs == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        for (Object obj : this.extraArgs.getFilteredArgs(locale)) {
            sb.append(obj);
        }
        return sb.toString();
    }

    public String formatWithTimeZone(String str, Object[] objArr, Locale locale, TimeZone timeZone) {
        MessageFormat messageFormat = new MessageFormat(" ");
        messageFormat.setLocale(locale);
        messageFormat.applyPattern(str);
        if (!timeZone.equals(TimeZone.getDefault())) {
            Format[] formats = messageFormat.getFormats();
            for (int i = 0; i < formats.length; i++) {
                Format format = formats[i];
                if (format instanceof DateFormat) {
                    DateFormat dateFormat = (DateFormat) format;
                    dateFormat.setTimeZone(timeZone);
                    messageFormat.setFormat(i, dateFormat);
                }
            }
        }
        return messageFormat.format(objArr);
    }

    public Object[] getArguments() {
        return this.arguments.getArguments();
    }

    public ClassLoader getClassLoader() {
        return this.f21225loader;
    }

    public String getEntry(String str, Locale locale, TimeZone timeZone) {
        String str2 = this.f21224id;
        if (str != null) {
            str2 = str2 + "." + str;
        }
        String str3 = str2;
        try {
            ClassLoader classLoader = this.f21225loader;
            String string = (classLoader == null ? ResourceBundle.getBundle(this.resource, locale) : ResourceBundle.getBundle(this.resource, locale, classLoader)).getString(str3);
            if (!this.encoding.equals("ISO-8859-1")) {
                string = new String(string.getBytes("ISO-8859-1"), this.encoding);
            }
            if (!this.arguments.m15983isEmpty()) {
                string = formatWithTimeZone(string, this.arguments.getFilteredArgs(locale), locale, timeZone);
            }
            return addExtraArgs(string, locale);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (MissingResourceException unused) {
            String str4 = "Can't find entry " + str3 + " in resource file " + this.resource + ".";
            String str5 = this.resource;
            ClassLoader classLoader2 = this.f21225loader;
            throw new MissingEntryException(str4, str5, str3, locale, classLoader2 != null ? classLoader2 : this.getClassLoader());
        }
    }

    public Object[] getExtraArgs() {
        FilteredArguments filteredArguments = this.extraArgs;
        if (filteredArguments == null) {
            return null;
        }
        return filteredArguments.getArguments();
    }

    public InterfaceC5449Filter getFilter() {
        return this.f21223filter;
    }

    /* renamed from: getId */
    public String m15981getId() {
        return this.f21224id;
    }

    public String getResource() {
        return this.resource;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.f21225loader = classLoader;
    }

    public void setExtraArgument(Object obj) {
        setExtraArguments(new Object[]{obj});
    }

    public void setExtraArguments(Object[] objArr) {
        if (objArr == null) {
            this.extraArgs = null;
            return;
        }
        FilteredArguments filteredArguments = new FilteredArguments(objArr);
        this.extraArgs = filteredArguments;
        filteredArguments.setFilter(this.f21223filter);
    }

    public void setFilter(InterfaceC5449Filter interfaceC5449Filter) {
        this.arguments.setFilter(interfaceC5449Filter);
        FilteredArguments filteredArguments = this.extraArgs;
        if (filteredArguments != null) {
            filteredArguments.setFilter(interfaceC5449Filter);
        }
        this.f21223filter = interfaceC5449Filter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Resource: \"");
        sb.append(this.resource);
        sb.append("\" Id: \"");
        sb.append(this.f21224id);
        sb.append("\"");
        sb.append(" Arguments: ");
        sb.append(this.arguments.getArguments().length);
        sb.append(" normal");
        FilteredArguments filteredArguments = this.extraArgs;
        if (filteredArguments != null && filteredArguments.getArguments().length > 0) {
            sb.append(", ");
            sb.append(this.extraArgs.getArguments().length);
            sb.append(" extra");
        }
        sb.append(" Encoding: ");
        sb.append(this.encoding);
        sb.append(" ClassLoader: ");
        sb.append(this.f21225loader);
        return sb.toString();
    }

    public LocalizedMessage(String str, String str2, String str3) throws UnsupportedEncodingException {
        this.encoding = "ISO-8859-1";
        this.extraArgs = null;
        this.f21223filter = null;
        this.f21225loader = null;
        if (str == null || str2 == null) {
            throw null;
        }
        this.f21224id = str2;
        this.resource = str;
        this.arguments = new FilteredArguments();
        if (Charset.isSupported(str3)) {
            this.encoding = str3;
            return;
        }
        throw new UnsupportedEncodingException("The encoding \"" + str3 + "\" is not supported.");
    }

    public LocalizedMessage(String str, String str2, String str3, Object[] objArr) throws UnsupportedEncodingException {
        this.encoding = "ISO-8859-1";
        this.extraArgs = null;
        this.f21223filter = null;
        this.f21225loader = null;
        if (str == null || str2 == null || objArr == null) {
            throw null;
        }
        this.f21224id = str2;
        this.resource = str;
        this.arguments = new FilteredArguments(objArr);
        if (Charset.isSupported(str3)) {
            this.encoding = str3;
            return;
        }
        throw new UnsupportedEncodingException("The encoding \"" + str3 + "\" is not supported.");
    }

    public LocalizedMessage(String str, String str2, Object[] objArr) {
        this.encoding = "ISO-8859-1";
        this.extraArgs = null;
        this.f21223filter = null;
        this.f21225loader = null;
        if (str == null || str2 == null || objArr == null) {
            throw null;
        }
        this.f21224id = str2;
        this.resource = str;
        this.arguments = new FilteredArguments(objArr);
    }
}
