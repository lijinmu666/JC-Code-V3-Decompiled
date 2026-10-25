package p131o;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.p038google.p061crypto.p062tink.DeterministicAead;
import com.p038google.p061crypto.p062tink.InterfaceC0305Aead;
import com.p038google.p061crypto.p062tink.KeyTemplate;
import com.p038google.p061crypto.p062tink.KeyTemplates;
import com.p038google.p061crypto.p062tink.KeysetHandle;
import com.p038google.p061crypto.p062tink.integration.p069android.AndroidKeysetManager;
import com.p038google.p061crypto.p062tink.integration.p069android.AndroidKeystoreKmsClient;
import com.p038google.p061crypto.p062tink.p063aead.AeadConfig;
import com.p038google.p061crypto.p062tink.p066daead.DeterministicAeadConfig;
import com.p038google.p061crypto.p062tink.p075subtle.C0852Base64;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: o.ofUPN */
/* loaded from: classes.dex */
public final class SharedPreferencesC4295ofUPN implements SharedPreferences {

    /* renamed from: AZxh */
    public final CopyOnWriteArrayList f15788AZxh = new CopyOnWriteArrayList();

    /* renamed from: JHa */
    public final DeterministicAead f15789JHa;

    /* renamed from: KLFTb */
    public final InterfaceC0305Aead f15790KLFTb;

    /* renamed from: ZfxDd */
    public final String f15791ZfxDd;

    /* renamed from: mjFkc */
    public final SharedPreferences f15792mjFkc;

    /* renamed from: wA */
    public final String f15793wA;

    /* renamed from: o.ofUPN$AZxh */
    public static final class AZxh implements SharedPreferences.Editor {

        /* renamed from: AZxh */
        public final SharedPreferences.Editor f15794AZxh;

        /* renamed from: mjFkc */
        public final SharedPreferencesC4295ofUPN f15796mjFkc;

        /* renamed from: ZfxDd */
        public final AtomicBoolean f15795ZfxDd = new AtomicBoolean(false);

        /* renamed from: wA */
        public final List f15797wA = new CopyOnWriteArrayList();

        public AZxh(SharedPreferencesC4295ofUPN sharedPreferencesC4295ofUPN, SharedPreferences.Editor editor) {
            this.f15796mjFkc = sharedPreferencesC4295ofUPN;
            this.f15794AZxh = editor;
        }

        /* renamed from: AZxh */
        public final void m13011AZxh() {
            Iterator it = this.f15796mjFkc.f15788AZxh.iterator();
            while (it.hasNext()) {
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = (SharedPreferences.OnSharedPreferenceChangeListener) it.next();
                Iterator it2 = this.f15797wA.iterator();
                while (it2.hasNext()) {
                    onSharedPreferenceChangeListener.onSharedPreferenceChanged(this.f15796mjFkc, (String) it2.next());
                }
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            m13012mjFkc();
            this.f15794AZxh.apply();
            m13011AZxh();
            this.f15797wA.clear();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.f15795ZfxDd.set(true);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            m13012mjFkc();
            try {
                return this.f15794AZxh.commit();
            } finally {
                m13011AZxh();
                this.f15797wA.clear();
            }
        }

        /* renamed from: mjFkc */
        public final void m13012mjFkc() {
            if (this.f15795ZfxDd.getAndSet(false)) {
                for (String str : this.f15796mjFkc.getAll().keySet()) {
                    if (!this.f15797wA.contains(str) && !this.f15796mjFkc.m13010xJ(str)) {
                        this.f15794AZxh.remove(this.f15796mjFkc.m13008ZfxDd(str));
                    }
                }
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(5);
            byteBufferAllocate.putInt(wA.BOOLEAN.m13026qdMbNW());
            byteBufferAllocate.put(z ? (byte) 1 : (byte) 0);
            m13013wA(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
            byteBufferAllocate.putInt(wA.FLOAT.m13026qdMbNW());
            byteBufferAllocate.putFloat(f);
            m13013wA(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
            byteBufferAllocate.putInt(wA.INT.m13026qdMbNW());
            byteBufferAllocate.putInt(i);
            m13013wA(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(12);
            byteBufferAllocate.putInt(wA.LONG.m13026qdMbNW());
            byteBufferAllocate.putLong(j);
            m13013wA(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            if (str2 == null) {
                str2 = "__NULL__";
            }
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            int length = bytes.length;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length + 8);
            byteBufferAllocate.putInt(wA.STRING.m13026qdMbNW());
            byteBufferAllocate.putInt(length);
            byteBufferAllocate.put(bytes);
            m13013wA(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set set) {
            if (set == null) {
                set = new C3762gYa();
                set.add("__NULL__");
            }
            ArrayList<byte[]> arrayList = new ArrayList(set.size());
            int size = set.size() * 4;
            Iterator it = set.iterator();
            while (it.hasNext()) {
                byte[] bytes = ((String) it.next()).getBytes(StandardCharsets.UTF_8);
                arrayList.add(bytes);
                size += bytes.length;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(size + 4);
            byteBufferAllocate.putInt(wA.STRING_SET.m13026qdMbNW());
            for (byte[] bArr : arrayList) {
                byteBufferAllocate.putInt(bArr.length);
                byteBufferAllocate.put(bArr);
            }
            m13013wA(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            if (!this.f15796mjFkc.m13010xJ(str)) {
                this.f15794AZxh.remove(this.f15796mjFkc.m13008ZfxDd(str));
                this.f15797wA.add(str);
                return this;
            }
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }

        /* renamed from: wA */
        public final void m13013wA(String str, byte[] bArr) {
            if (this.f15796mjFkc.m13010xJ(str)) {
                throw new SecurityException(str + " is a reserved key for the encryption keyset.");
            }
            this.f15797wA.add(str);
            if (str == null) {
                str = "__NULL__";
            }
            try {
                Pair pairM13007KLFTb = this.f15796mjFkc.m13007KLFTb(str, bArr);
                this.f15794AZxh.putString((String) pairM13007KLFTb.first, (String) pairM13007KLFTb.second);
            } catch (GeneralSecurityException e) {
                throw new SecurityException("Could not encrypt data: " + e.getMessage(), e);
            }
        }
    }

    /* renamed from: o.ofUPN$KLFTb */
    public enum KLFTb {
        AES256_GCM("AES256_GCM");


        /* renamed from: mjFkc */
        public final String f15800mjFkc;

        KLFTb(String str) {
            this.f15800mjFkc = str;
        }

        /* renamed from: lgHUyS */
        public KeyTemplate m13017lgHUyS() {
            return KeyTemplates.m3346get(this.f15800mjFkc);
        }
    }

    /* renamed from: o.ofUPN$ZfxDd */
    public enum ZfxDd {
        AES256_SIV("AES256_SIV");


        /* renamed from: mjFkc */
        public final String f15803mjFkc;

        ZfxDd(String str) {
            this.f15803mjFkc = str;
        }

        /* renamed from: lgHUyS */
        public KeyTemplate m13021lgHUyS() {
            return KeyTemplates.m3346get(this.f15803mjFkc);
        }
    }

    /* renamed from: o.ofUPN$mjFkc */
    public static /* synthetic */ class mjFkc {

        /* renamed from: mjFkc */
        public static final /* synthetic */ int[] f15804mjFkc;

        static {
            int[] iArr = new int[wA.m13025values().length];
            f15804mjFkc = iArr;
            try {
                iArr[wA.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15804mjFkc[wA.INT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15804mjFkc[wA.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15804mjFkc[wA.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15804mjFkc[wA.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15804mjFkc[wA.STRING_SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: o.ofUPN$wA */
    public enum wA {
        STRING(0),
        STRING_SET(1),
        INT(2),
        LONG(3),
        FLOAT(4),
        BOOLEAN(5);


        /* renamed from: mjFkc */
        public final int f15812mjFkc;

        wA(int i) {
            this.f15812mjFkc = i;
        }

        /* renamed from: lgHUyS */
        public static wA m13023lgHUyS(int i) {
            if (i == 0) {
                return STRING;
            }
            if (i == 1) {
                return STRING_SET;
            }
            if (i == 2) {
                return INT;
            }
            if (i == 3) {
                return LONG;
            }
            if (i == 4) {
                return FLOAT;
            }
            if (i != 5) {
                return null;
            }
            return BOOLEAN;
        }

        /* renamed from: qdMbNW */
        public int m13026qdMbNW() {
            return this.f15812mjFkc;
        }
    }

    public SharedPreferencesC4295ofUPN(String str, String str2, SharedPreferences sharedPreferences, InterfaceC0305Aead interfaceC0305Aead, DeterministicAead deterministicAead) {
        this.f15793wA = str;
        this.f15792mjFkc = sharedPreferences;
        this.f15791ZfxDd = str2;
        this.f15790KLFTb = interfaceC0305Aead;
        this.f15789JHa = deterministicAead;
    }

    /* renamed from: AZxh */
    public static SharedPreferences m13004AZxh(String str, String str2, Context context, ZfxDd zfxDd, KLFTb kLFTb) {
        DeterministicAeadConfig.register();
        AeadConfig.register();
        Context applicationContext = context.getApplicationContext();
        KeysetHandle keysetHandle = new AndroidKeysetManager.C0412Builder().withKeyTemplate(zfxDd.m13021lgHUyS()).withSharedPref(applicationContext, "__androidx_security_crypto_encrypted_prefs_key_keyset__", str).withMasterKeyUri(AndroidKeystoreKmsClient.f3101PREFIX + str2).m3477build().getKeysetHandle();
        KeysetHandle keysetHandle2 = new AndroidKeysetManager.C0412Builder().withKeyTemplate(kLFTb.m13017lgHUyS()).withSharedPref(applicationContext, "__androidx_security_crypto_encrypted_prefs_value_keyset__", str).withMasterKeyUri(AndroidKeystoreKmsClient.f3101PREFIX + str2).m3477build().getKeysetHandle();
        return new SharedPreferencesC4295ofUPN(str, str2, applicationContext.getSharedPreferences(str, 0), (InterfaceC0305Aead) keysetHandle2.getPrimitive(InterfaceC0305Aead.class), (DeterministicAead) keysetHandle.getPrimitive(DeterministicAead.class));
    }

    /* renamed from: mjFkc */
    public static SharedPreferences m13005mjFkc(Context context, String str, C1664B1 c1664b1, ZfxDd zfxDd, KLFTb kLFTb) {
        return m13004AZxh(str, c1664b1.m7647mjFkc(), context, zfxDd, kLFTb);
    }

    /* renamed from: JHa */
    public final Object m13006JHa(String str) {
        if (m13010xJ(str)) {
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }
        if (str == null) {
            str = "__NULL__";
        }
        try {
            String strM13008ZfxDd = m13008ZfxDd(str);
            String string = this.f15792mjFkc.getString(strM13008ZfxDd, null);
            if (string == null) {
                return null;
            }
            byte[] bArrM4222decode = C0852Base64.m4222decode(string, 0);
            InterfaceC0305Aead interfaceC0305Aead = this.f15790KLFTb;
            Charset charset = StandardCharsets.UTF_8;
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(interfaceC0305Aead.mo3322decrypt(bArrM4222decode, strM13008ZfxDd.getBytes(charset)));
            byteBufferWrap.position(0);
            int i = byteBufferWrap.getInt();
            wA wAVarM13023lgHUyS = wA.m13023lgHUyS(i);
            if (wAVarM13023lgHUyS == null) {
                throw new SecurityException("Unknown type ID for encrypted pref value: " + i);
            }
            switch (mjFkc.f15804mjFkc[wAVarM13023lgHUyS.ordinal()]) {
                case 1:
                    int i2 = byteBufferWrap.getInt();
                    ByteBuffer byteBufferSlice = byteBufferWrap.slice();
                    byteBufferWrap.limit(i2);
                    String string2 = charset.decode(byteBufferSlice).toString();
                    if (string2.equals("__NULL__")) {
                        return null;
                    }
                    return string2;
                case 2:
                    return Integer.valueOf(byteBufferWrap.getInt());
                case 3:
                    return Long.valueOf(byteBufferWrap.getLong());
                case 4:
                    return Float.valueOf(byteBufferWrap.getFloat());
                case 5:
                    return Boolean.valueOf(byteBufferWrap.get() != 0);
                case 6:
                    C3762gYa c3762gYa = new C3762gYa();
                    while (byteBufferWrap.hasRemaining()) {
                        int i3 = byteBufferWrap.getInt();
                        ByteBuffer byteBufferSlice2 = byteBufferWrap.slice();
                        byteBufferSlice2.limit(i3);
                        byteBufferWrap.position(byteBufferWrap.position() + i3);
                        c3762gYa.add(StandardCharsets.UTF_8.decode(byteBufferSlice2).toString());
                    }
                    if (c3762gYa.size() == 1 && "__NULL__".equals(c3762gYa.m11997ETF(0))) {
                        return null;
                    }
                    return c3762gYa;
                default:
                    throw new SecurityException("Unhandled type for encrypted pref value: " + wAVarM13023lgHUyS);
            }
        } catch (GeneralSecurityException e) {
            throw new SecurityException("Could not decrypt value. " + e.getMessage(), e);
        }
    }

    /* renamed from: KLFTb */
    public Pair m13007KLFTb(String str, byte[] bArr) {
        String strM13008ZfxDd = m13008ZfxDd(str);
        return new Pair(strM13008ZfxDd, C0852Base64.m4225encode(this.f15790KLFTb.mo3323encrypt(bArr, strM13008ZfxDd.getBytes(StandardCharsets.UTF_8))));
    }

    /* renamed from: ZfxDd */
    public String m13008ZfxDd(String str) {
        if (str == null) {
            str = "__NULL__";
        }
        try {
            return C0852Base64.m4225encode(this.f15789JHa.encryptDeterministically(str.getBytes(StandardCharsets.UTF_8), this.f15793wA.getBytes()));
        } catch (GeneralSecurityException e) {
            throw new SecurityException("Could not encrypt key. " + e.getMessage(), e);
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        if (!m13010xJ(str)) {
            return this.f15792mjFkc.contains(m13008ZfxDd(str));
        }
        throw new SecurityException(str + " is a reserved key for the encryption keyset.");
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new AZxh(this, this.f15792mjFkc.edit());
    }

    @Override // android.content.SharedPreferences
    public Map getAll() {
        HashMap map = new HashMap();
        for (Map.Entry<String, ?> entry : this.f15792mjFkc.getAll().entrySet()) {
            if (!m13010xJ(entry.getKey())) {
                String strM13009wA = m13009wA(entry.getKey());
                map.put(strM13009wA, m13006JHa(strM13009wA));
            }
        }
        return map;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        Object objM13006JHa = m13006JHa(str);
        return objM13006JHa instanceof Boolean ? ((Boolean) objM13006JHa).booleanValue() : z;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        Object objM13006JHa = m13006JHa(str);
        return objM13006JHa instanceof Float ? ((Float) objM13006JHa).floatValue() : f;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        Object objM13006JHa = m13006JHa(str);
        return objM13006JHa instanceof Integer ? ((Integer) objM13006JHa).intValue() : i;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        Object objM13006JHa = m13006JHa(str);
        return objM13006JHa instanceof Long ? ((Long) objM13006JHa).longValue() : j;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        Object objM13006JHa = m13006JHa(str);
        return objM13006JHa instanceof String ? (String) objM13006JHa : str2;
    }

    @Override // android.content.SharedPreferences
    public Set getStringSet(String str, Set set) {
        Object objM13006JHa = m13006JHa(str);
        Set c3762gYa = objM13006JHa instanceof Set ? (Set) objM13006JHa : new C3762gYa();
        return c3762gYa.size() > 0 ? c3762gYa : set;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f15788AZxh.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f15788AZxh.remove(onSharedPreferenceChangeListener);
    }

    /* renamed from: wA */
    public String m13009wA(String str) {
        try {
            String str2 = new String(this.f15789JHa.decryptDeterministically(C0852Base64.m4222decode(str, 0), this.f15793wA.getBytes()), StandardCharsets.UTF_8);
            if (str2.equals("__NULL__")) {
                return null;
            }
            return str2;
        } catch (GeneralSecurityException e) {
            throw new SecurityException("Could not decrypt key. " + e.getMessage(), e);
        }
    }

    /* renamed from: xJ */
    public boolean m13010xJ(String str) {
        return "__androidx_security_crypto_encrypted_prefs_key_keyset__".equals(str) || "__androidx_security_crypto_encrypted_prefs_value_keyset__".equals(str);
    }
}
