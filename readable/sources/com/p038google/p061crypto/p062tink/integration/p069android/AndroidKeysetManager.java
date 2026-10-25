package com.p038google.p061crypto.p062tink.integration.p069android;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Log;
import com.p038google.p061crypto.p062tink.BinaryKeysetReader;
import com.p038google.p061crypto.p062tink.CleartextKeysetHandle;
import com.p038google.p061crypto.p062tink.InterfaceC0305Aead;
import com.p038google.p061crypto.p062tink.KeyTemplate;
import com.p038google.p061crypto.p062tink.KeysetHandle;
import com.p038google.p061crypto.p062tink.KeysetManager;
import com.p038google.p061crypto.p062tink.KeysetWriter;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;
import com.p038google.p061crypto.p062tink.p075subtle.C0865Hex;
import java.io.CharConversionException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class AndroidKeysetManager {

    /* renamed from: TAG */
    private static final String f3095TAG = "AndroidKeysetManager";

    /* renamed from: lock */
    private static final Object f3096lock = new Object();

    @GuardedBy("this")
    private KeysetManager keysetManager;
    private final InterfaceC0305Aead masterAead;

    /* renamed from: writer */
    private final KeysetWriter f3097writer;

    /* renamed from: com.google.crypto.tink.integration.android.AndroidKeysetManager$1 */
    public static /* synthetic */ class C04111 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType;

        static {
            int[] iArr = new int[OutputPrefixType.m3816values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = iArr;
            try {
                iArr[OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public /* synthetic */ AndroidKeysetManager(C0412Builder c0412Builder, C04111 c04111) {
        this(c0412Builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTemplate.OutputPrefixType fromProto(OutputPrefixType outputPrefixType) {
        int i = C04111.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (i == 1) {
            return KeyTemplate.OutputPrefixType.TINK;
        }
        if (i == 2) {
            return KeyTemplate.OutputPrefixType.LEGACY;
        }
        if (i == 3) {
            return KeyTemplate.OutputPrefixType.RAW;
        }
        if (i == 4) {
            return KeyTemplate.OutputPrefixType.CRUNCHY;
        }
        throw new IllegalArgumentException("Unknown output prefix type");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAtLeastM() {
        return true;
    }

    private boolean shouldUseKeystore() {
        return this.masterAead != null && isAtLeastM();
    }

    /* renamed from: write */
    private void m3468write(KeysetManager keysetManager) throws GeneralSecurityException {
        try {
            if (shouldUseKeystore()) {
                keysetManager.getKeysetHandle().m3355write(this.f3097writer, this.masterAead);
            } else {
                CleartextKeysetHandle.m3329write(keysetManager.getKeysetHandle(), this.f3097writer);
            }
        } catch (IOException e) {
            throw new GeneralSecurityException(e);
        }
    }

    @GuardedBy("this")
    @Deprecated
    /* renamed from: add */
    public synchronized AndroidKeysetManager m3470add(com.p038google.p061crypto.p062tink.p073proto.KeyTemplate keyTemplate) {
        KeysetManager keysetManagerM3364add = this.keysetManager.m3364add(keyTemplate);
        this.keysetManager = keysetManagerM3364add;
        m3468write(keysetManagerM3364add);
        return this;
    }

    /* renamed from: delete */
    public synchronized AndroidKeysetManager m3471delete(int i) {
        KeysetManager keysetManagerM3367delete = this.keysetManager.m3367delete(i);
        this.keysetManager = keysetManagerM3367delete;
        m3468write(keysetManagerM3367delete);
        return this;
    }

    /* renamed from: destroy */
    public synchronized AndroidKeysetManager m3472destroy(int i) {
        KeysetManager keysetManagerM3368destroy = this.keysetManager.m3368destroy(i);
        this.keysetManager = keysetManagerM3368destroy;
        m3468write(keysetManagerM3368destroy);
        return this;
    }

    /* renamed from: disable */
    public synchronized AndroidKeysetManager m3473disable(int i) {
        KeysetManager keysetManagerM3369disable = this.keysetManager.m3369disable(i);
        this.keysetManager = keysetManagerM3369disable;
        m3468write(keysetManagerM3369disable);
        return this;
    }

    /* renamed from: enable */
    public synchronized AndroidKeysetManager m3474enable(int i) {
        KeysetManager keysetManagerM3370enable = this.keysetManager.m3370enable(i);
        this.keysetManager = keysetManagerM3370enable;
        m3468write(keysetManagerM3370enable);
        return this;
    }

    public synchronized KeysetHandle getKeysetHandle() {
        return this.keysetManager.getKeysetHandle();
    }

    public synchronized boolean isUsingKeystore() {
        return shouldUseKeystore();
    }

    @Deprecated
    /* renamed from: promote */
    public synchronized AndroidKeysetManager m3475promote(int i) {
        return setPrimary(i);
    }

    @Deprecated
    /* renamed from: rotate */
    public synchronized AndroidKeysetManager m3476rotate(com.p038google.p061crypto.p062tink.p073proto.KeyTemplate keyTemplate) {
        KeysetManager keysetManagerM3372rotate = this.keysetManager.m3372rotate(keyTemplate);
        this.keysetManager = keysetManagerM3372rotate;
        m3468write(keysetManagerM3372rotate);
        return this;
    }

    public synchronized AndroidKeysetManager setPrimary(int i) {
        KeysetManager primary = this.keysetManager.setPrimary(i);
        this.keysetManager = primary;
        m3468write(primary);
        return this;
    }

    /* renamed from: com.google.crypto.tink.integration.android.AndroidKeysetManager$Builder */
    public static final class C0412Builder {

        @GuardedBy("this")
        private KeysetManager keysetManager;

        /* renamed from: context */
        private Context f3098context = null;
        private String keysetName = null;
        private String prefFileName = null;
        private String masterKeyUri = null;
        private InterfaceC0305Aead masterAead = null;
        private boolean useKeystore = true;
        private KeyTemplate keyTemplate = null;

        private KeysetManager generateKeysetAndWriteToPrefs() throws GeneralSecurityException {
            if (this.keyTemplate == null) {
                throw new GeneralSecurityException("cannot read or generate keyset");
            }
            KeysetManager keysetManagerM3363add = KeysetManager.withEmptyKeyset().m3363add(this.keyTemplate);
            KeysetManager primary = keysetManagerM3363add.setPrimary(keysetManagerM3363add.getKeysetHandle().getKeysetInfo().getKeyInfo(0).getKeyId());
            SharedPrefKeysetWriter sharedPrefKeysetWriter = new SharedPrefKeysetWriter(this.f3098context, this.keysetName, this.prefFileName);
            if (this.masterAead != null) {
                primary.getKeysetHandle().m3355write(sharedPrefKeysetWriter, this.masterAead);
            } else {
                CleartextKeysetHandle.m3329write(primary.getKeysetHandle(), sharedPrefKeysetWriter);
            }
            return primary;
        }

        private static byte[] readKeysetFromPrefs(Context context, String str, String str2) throws CharConversionException {
            if (str == null) {
                throw new IllegalArgumentException("keysetName cannot be null");
            }
            Context applicationContext = context.getApplicationContext();
            try {
                String string = (str2 == null ? PreferenceManager.getDefaultSharedPreferences(applicationContext) : applicationContext.getSharedPreferences(str2, 0)).getString(str, null);
                if (string == null) {
                    return null;
                }
                return C0865Hex.m4274decode(string);
            } catch (ClassCastException | IllegalArgumentException unused) {
                throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", str));
            }
        }

        private KeysetManager readKeysetInCleartext(byte[] bArr) {
            return KeysetManager.withKeysetHandle(CleartextKeysetHandle.m3327read(BinaryKeysetReader.withBytes(bArr)));
        }

        private KeysetManager readMasterkeyDecryptAndParseKeyset(byte[] bArr) {
            try {
                this.masterAead = new AndroidKeystoreKmsClient().mo3373getAead(this.masterKeyUri);
                try {
                    return KeysetManager.withKeysetHandle(KeysetHandle.m3351read(BinaryKeysetReader.withBytes(bArr), this.masterAead));
                } catch (IOException | GeneralSecurityException e) {
                    try {
                        return this.readKeysetInCleartext(bArr);
                    } catch (IOException unused) {
                        throw e;
                    }
                }
            } catch (GeneralSecurityException | ProviderException e2) {
                try {
                    KeysetManager keysetInCleartext = readKeysetInCleartext(bArr);
                    Log.w(AndroidKeysetManager.f3095TAG, "cannot use Android Keystore, it'll be disabled", e2);
                    return keysetInCleartext;
                } catch (IOException unused2) {
                    throw e2;
                }
            }
        }

        private InterfaceC0305Aead readOrGenerateNewMasterKey() throws KeyStoreException {
            if (!AndroidKeysetManager.isAtLeastM()) {
                Log.w(AndroidKeysetManager.f3095TAG, "Android Keystore requires at least Android M");
                return null;
            }
            AndroidKeystoreKmsClient androidKeystoreKmsClient = new AndroidKeystoreKmsClient();
            try {
                boolean zGenerateKeyIfNotExist = AndroidKeystoreKmsClient.generateKeyIfNotExist(this.masterKeyUri);
                try {
                    return androidKeystoreKmsClient.mo3373getAead(this.masterKeyUri);
                } catch (GeneralSecurityException | ProviderException e) {
                    if (!zGenerateKeyIfNotExist) {
                        throw new KeyStoreException(String.format("the master key %s exists but is unusable", this.masterKeyUri), e);
                    }
                    Log.w(AndroidKeysetManager.f3095TAG, "cannot use Android Keystore, it'll be disabled", e);
                    return null;
                }
            } catch (GeneralSecurityException | ProviderException e2) {
                Log.w(AndroidKeysetManager.f3095TAG, "cannot use Android Keystore, it'll be disabled", e2);
                return null;
            }
        }

        /* renamed from: build */
        public synchronized AndroidKeysetManager m3477build() {
            AndroidKeysetManager androidKeysetManager;
            try {
                if (this.keysetName == null) {
                    throw new IllegalArgumentException("keysetName cannot be null");
                }
                synchronized (AndroidKeysetManager.f3096lock) {
                    try {
                        byte[] keysetFromPrefs = readKeysetFromPrefs(this.f3098context, this.keysetName, this.prefFileName);
                        if (keysetFromPrefs == null) {
                            if (this.masterKeyUri != null) {
                                this.masterAead = readOrGenerateNewMasterKey();
                            }
                            this.keysetManager = generateKeysetAndWriteToPrefs();
                        } else if (this.masterKeyUri == null || !AndroidKeysetManager.isAtLeastM()) {
                            this.keysetManager = readKeysetInCleartext(keysetFromPrefs);
                        } else {
                            this.keysetManager = readMasterkeyDecryptAndParseKeyset(keysetFromPrefs);
                        }
                        androidKeysetManager = new AndroidKeysetManager(this, null);
                    } finally {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
            return androidKeysetManager;
        }

        @Deprecated
        public C0412Builder doNotUseKeystore() {
            this.masterKeyUri = null;
            this.useKeystore = false;
            return this;
        }

        @Deprecated
        public C0412Builder withKeyTemplate(com.p038google.p061crypto.p062tink.p073proto.KeyTemplate keyTemplate) {
            this.keyTemplate = KeyTemplate.m3342create(keyTemplate.getTypeUrl(), keyTemplate.getValue().toByteArray(), AndroidKeysetManager.fromProto(keyTemplate.getOutputPrefixType()));
            return this;
        }

        public C0412Builder withMasterKeyUri(String str) {
            if (!str.startsWith(AndroidKeystoreKmsClient.f3101PREFIX)) {
                throw new IllegalArgumentException("key URI must start with android-keystore://");
            }
            if (!this.useKeystore) {
                throw new IllegalArgumentException("cannot call withMasterKeyUri() after calling doNotUseKeystore()");
            }
            this.masterKeyUri = str;
            return this;
        }

        public C0412Builder withSharedPref(Context context, String str, String str2) {
            if (context == null) {
                throw new IllegalArgumentException("need an Android context");
            }
            if (str == null) {
                throw new IllegalArgumentException("need a keyset name");
            }
            this.f3098context = context;
            this.keysetName = str;
            this.prefFileName = str2;
            return this;
        }

        public C0412Builder withKeyTemplate(KeyTemplate keyTemplate) {
            this.keyTemplate = keyTemplate;
            return this;
        }
    }

    private AndroidKeysetManager(C0412Builder c0412Builder) {
        this.f3097writer = new SharedPrefKeysetWriter(c0412Builder.f3098context, c0412Builder.keysetName, c0412Builder.prefFileName);
        this.masterAead = c0412Builder.masterAead;
        this.keysetManager = c0412Builder.keysetManager;
    }

    @GuardedBy("this")
    /* renamed from: add */
    public synchronized AndroidKeysetManager m3469add(KeyTemplate keyTemplate) {
        KeysetManager keysetManagerM3363add = this.keysetManager.m3363add(keyTemplate);
        this.keysetManager = keysetManagerM3363add;
        m3468write(keysetManagerM3363add);
        return this;
    }
}
