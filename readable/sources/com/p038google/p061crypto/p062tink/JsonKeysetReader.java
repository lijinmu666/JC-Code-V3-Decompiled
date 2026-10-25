package com.p038google.p061crypto.p062tink;

import com.p038google.p061crypto.p062tink.internal.JsonParser;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.C0675Keyset;
import com.p038google.p061crypto.p062tink.p073proto.EncryptedKeyset;
import com.p038google.p061crypto.p062tink.p073proto.KeyStatusType;
import com.p038google.p061crypto.p062tink.p073proto.KeysetInfo;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p075subtle.C0852Base64;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;
import p131o.AbstractC4187n0;
import p131o.C3858i0;
import p131o.C4385q0;
import p131o.C4454r0;

/* loaded from: classes.dex */
public final class JsonKeysetReader implements KeysetReader {
    private static final long MAX_KEY_ID = 4294967295L;
    private static final long MIN_KEY_ID = -2147483648L;

    /* renamed from: UTF_8 */
    private static final Charset f2988UTF_8 = Charset.forName("UTF-8");
    private final InputStream inputStream;
    private boolean urlSafeBase64 = false;

    private JsonKeysetReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    private EncryptedKeyset encryptedKeysetFromJson(C4385q0 c4385q0) {
        validateEncryptedKeyset(c4385q0);
        byte[] bArrUrlSafeDecode = this.urlSafeBase64 ? C0852Base64.urlSafeDecode(c4385q0.m13154Ucbh("encryptedKeyset").mo12267VA()) : C0852Base64.m4221decode(c4385q0.m13154Ucbh("encryptedKeyset").mo12267VA());
        return c4385q0.m13151HGpJ("keysetInfo") ? EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(bArrUrlSafeDecode)).setKeysetInfo(keysetInfoFromJson(c4385q0.m13150Gd("keysetInfo"))).mo3555build() : EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(bArrUrlSafeDecode)).mo3555build();
    }

    private static int getKeyId(AbstractC4187n0 abstractC4187n0) throws IOException {
        try {
            long parsedNumberAsLongOrThrow = JsonParser.getParsedNumberAsLongOrThrow(abstractC4187n0);
            if (parsedNumberAsLongOrThrow > 4294967295L || parsedNumberAsLongOrThrow < MIN_KEY_ID) {
                throw new IOException("invalid key id");
            }
            return (int) abstractC4187n0.mo12262Dt();
        } catch (NumberFormatException e) {
            throw new IOException(e);
        }
    }

    private static C0669KeyData.KeyMaterialType getKeyMaterialType(String str) {
        str.hashCode();
        switch (str) {
            case "REMOTE":
                return C0669KeyData.KeyMaterialType.REMOTE;
            case "SYMMETRIC":
                return C0669KeyData.KeyMaterialType.SYMMETRIC;
            case "ASYMMETRIC_PRIVATE":
                return C0669KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
            case "ASYMMETRIC_PUBLIC":
                return C0669KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
            default:
                throw new C4454r0("unknown key material type: " + str);
        }
    }

    private static OutputPrefixType getOutputPrefixType(String str) {
        str.hashCode();
        switch (str) {
            case "LEGACY":
                return OutputPrefixType.LEGACY;
            case "RAW":
                return OutputPrefixType.RAW;
            case "TINK":
                return OutputPrefixType.TINK;
            case "CRUNCHY":
                return OutputPrefixType.CRUNCHY;
            default:
                throw new C4454r0("unknown output prefix type: " + str);
        }
    }

    private static KeyStatusType getStatus(String str) {
        str.hashCode();
        switch (str) {
            case "ENABLED":
                return KeyStatusType.ENABLED;
            case "DESTROYED":
                return KeyStatusType.DESTROYED;
            case "DISABLED":
                return KeyStatusType.DISABLED;
            default:
                throw new C4454r0("unknown status: " + str);
        }
    }

    private C0669KeyData keyDataFromJson(C4385q0 c4385q0) {
        validateKeyData(c4385q0);
        return C0669KeyData.newBuilder().setTypeUrl(c4385q0.m13154Ucbh("typeUrl").mo12267VA()).setValue(ByteString.copyFrom(this.urlSafeBase64 ? C0852Base64.urlSafeDecode(c4385q0.m13154Ucbh("value").mo12267VA()) : C0852Base64.m4221decode(c4385q0.m13154Ucbh("value").mo12267VA()))).setKeyMaterialType(getKeyMaterialType(c4385q0.m13154Ucbh("keyMaterialType").mo12267VA())).mo3555build();
    }

    private C0675Keyset.Key keyFromJson(C4385q0 c4385q0) {
        validateKey(c4385q0);
        return C0675Keyset.Key.newBuilder().setStatus(getStatus(c4385q0.m13154Ucbh("status").mo12267VA())).setKeyId(getKeyId(c4385q0.m13154Ucbh("keyId"))).setOutputPrefixType(getOutputPrefixType(c4385q0.m13154Ucbh("outputPrefixType").mo12267VA())).setKeyData(keyDataFromJson(c4385q0.m13150Gd("keyData"))).mo3555build();
    }

    private static KeysetInfo.C0678KeyInfo keyInfoFromJson(C4385q0 c4385q0) {
        return KeysetInfo.C0678KeyInfo.newBuilder().setStatus(getStatus(c4385q0.m13154Ucbh("status").mo12267VA())).setKeyId(getKeyId(c4385q0.m13154Ucbh("keyId"))).setOutputPrefixType(getOutputPrefixType(c4385q0.m13154Ucbh("outputPrefixType").mo12267VA())).setTypeUrl(c4385q0.m13154Ucbh("typeUrl").mo12267VA()).mo3555build();
    }

    private C0675Keyset keysetFromJson(C4385q0 c4385q0) {
        validateKeyset(c4385q0);
        C0675Keyset.Builder builderNewBuilder = C0675Keyset.newBuilder();
        if (c4385q0.m13151HGpJ("primaryKeyId")) {
            builderNewBuilder.setPrimaryKeyId(getKeyId(c4385q0.m13154Ucbh("primaryKeyId")));
        }
        C3858i0 c3858i0M13159huTpC = c4385q0.m13159huTpC("key");
        for (int i = 0; i < c3858i0M13159huTpC.m12273size(); i++) {
            builderNewBuilder.m3804addKey(keyFromJson(c3858i0M13159huTpC.m12269diqgf(i).m12832lgHUyS()));
        }
        return builderNewBuilder.mo3555build();
    }

    private static KeysetInfo keysetInfoFromJson(C4385q0 c4385q0) {
        KeysetInfo.C0677Builder c0677BuilderNewBuilder = KeysetInfo.newBuilder();
        if (c4385q0.m13151HGpJ("primaryKeyId")) {
            c0677BuilderNewBuilder.setPrimaryKeyId(getKeyId(c4385q0.m13154Ucbh("primaryKeyId")));
        }
        if (c4385q0.m13151HGpJ("keyInfo")) {
            C3858i0 c3858i0M13159huTpC = c4385q0.m13159huTpC("keyInfo");
            for (int i = 0; i < c3858i0M13159huTpC.m12273size(); i++) {
                c0677BuilderNewBuilder.addKeyInfo(keyInfoFromJson(c3858i0M13159huTpC.m12269diqgf(i).m12832lgHUyS()));
            }
        }
        return c0677BuilderNewBuilder.mo3555build();
    }

    private static void validateEncryptedKeyset(C4385q0 c4385q0) {
        if (!c4385q0.m13151HGpJ("encryptedKeyset")) {
            throw new C4454r0("invalid encrypted keyset");
        }
    }

    private static void validateKey(C4385q0 c4385q0) {
        if (!c4385q0.m13151HGpJ("keyData") || !c4385q0.m13151HGpJ("status") || !c4385q0.m13151HGpJ("keyId") || !c4385q0.m13151HGpJ("outputPrefixType")) {
            throw new C4454r0("invalid key");
        }
    }

    private static void validateKeyData(C4385q0 c4385q0) {
        if (!c4385q0.m13151HGpJ("typeUrl") || !c4385q0.m13151HGpJ("value") || !c4385q0.m13151HGpJ("keyMaterialType")) {
            throw new C4454r0("invalid keyData");
        }
    }

    private static void validateKeyset(C4385q0 c4385q0) {
        if (!c4385q0.m13151HGpJ("key") || c4385q0.m13159huTpC("key").m12273size() == 0) {
            throw new C4454r0("invalid keyset");
        }
    }

    public static JsonKeysetReader withBytes(byte[] bArr) {
        return new JsonKeysetReader(new ByteArrayInputStream(bArr));
    }

    @Deprecated
    public static JsonKeysetReader withFile(File file) {
        return withInputStream(new FileInputStream(file));
    }

    public static JsonKeysetReader withInputStream(InputStream inputStream) {
        return new JsonKeysetReader(inputStream);
    }

    @Deprecated
    public static JsonKeysetReader withJsonObject(Object obj) {
        return withString(obj.toString());
    }

    @Deprecated
    public static JsonKeysetReader withPath(String str) {
        return withInputStream(new FileInputStream(new File(str)));
    }

    public static JsonKeysetReader withString(String str) {
        return new JsonKeysetReader(new ByteArrayInputStream(str.getBytes(f2988UTF_8)));
    }

    @Override // com.p038google.p061crypto.p062tink.KeysetReader
    /* renamed from: read */
    public C0675Keyset mo3324read() throws IOException {
        try {
            try {
                return keysetFromJson(JsonParser.m3480parse(new String(C0323Util.m3393readAll(this.inputStream), f2988UTF_8)).m12832lgHUyS());
            } catch (IllegalStateException | C4454r0 e) {
                throw new IOException(e);
            }
        } finally {
            InputStream inputStream = this.inputStream;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    @Override // com.p038google.p061crypto.p062tink.KeysetReader
    public EncryptedKeyset readEncrypted() throws IOException {
        try {
            try {
                return encryptedKeysetFromJson(JsonParser.m3480parse(new String(C0323Util.m3393readAll(this.inputStream), f2988UTF_8)).m12832lgHUyS());
            } catch (IllegalStateException | C4454r0 e) {
                throw new IOException(e);
            }
        } finally {
            InputStream inputStream = this.inputStream;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public JsonKeysetReader withUrlSafeBase64() {
        this.urlSafeBase64 = true;
        return this;
    }

    @Deprecated
    public static JsonKeysetReader withPath(Path path) {
        return withInputStream(new FileInputStream(path.toFile()));
    }
}
