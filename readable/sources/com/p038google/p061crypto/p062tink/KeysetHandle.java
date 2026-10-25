package com.p038google.p061crypto.p062tink;

import com.p038google.p061crypto.p062tink.PrimitiveSet;
import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;
import com.p038google.p061crypto.p062tink.internal.C0431Util;
import com.p038google.p061crypto.p062tink.internal.LegacyProtoKey;
import com.p038google.p061crypto.p062tink.internal.LegacyProtoParameters;
import com.p038google.p061crypto.p062tink.internal.MutableSerializationRegistry;
import com.p038google.p061crypto.p062tink.internal.ProtoKeySerialization;
import com.p038google.p061crypto.p062tink.internal.ProtoParametersSerialization;
import com.p038google.p061crypto.p062tink.internal.TinkBugException;
import com.p038google.p061crypto.p062tink.monitoring.MonitoringAnnotations;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.C0675Keyset;
import com.p038google.p061crypto.p062tink.p073proto.EncryptedKeyset;
import com.p038google.p061crypto.p062tink.p073proto.KeyStatusType;
import com.p038google.p061crypto.p062tink.p073proto.KeyTemplate;
import com.p038google.p061crypto.p062tink.p073proto.KeysetInfo;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.InvalidProtocolBufferException;
import com.p038google.p061crypto.p062tink.p077tinkkey.KeyAccess;
import com.p038google.p061crypto.p062tink.p077tinkkey.KeyHandle;
import com.p038google.p061crypto.p062tink.p077tinkkey.internal.InternalKeyHandle;
import com.p038google.p061crypto.p062tink.p077tinkkey.internal.ProtoKey;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class KeysetHandle {
    private final MonitoringAnnotations annotations;

    /* renamed from: entries */
    private final List<C0316Entry> f2999entries;

    /* renamed from: keyset */
    private final C0675Keyset f3000keyset;

    /* renamed from: com.google.crypto.tink.KeysetHandle$1 */
    public static /* synthetic */ class C03141 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$KeyStatusType;

        static {
            int[] iArr = new int[KeyStatusType.m3793values().length];
            $SwitchMap$com$google$crypto$tink$proto$KeyStatusType = iArr;
            try {
                iArr[KeyStatusType.ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$KeyStatusType[KeyStatusType.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$KeyStatusType[KeyStatusType.DESTROYED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: com.google.crypto.tink.KeysetHandle$Builder */
    public static final class C0315Builder {

        /* renamed from: entries */
        private final List<Entry> f3001entries = new ArrayList();

        /* renamed from: com.google.crypto.tink.KeysetHandle$Builder$Entry */
        public static final class Entry {

            /* renamed from: builder */
            @Nullable
            private C0315Builder f3002builder;
            private boolean isPrimary;

            /* renamed from: key */
            @Nullable
            private final AbstractC0308Key f3003key;
            private KeyStatus keyStatus;

            @Nullable
            private final Parameters parameters;
            private KeyIdStrategy strategy;

            public /* synthetic */ Entry(AbstractC0308Key abstractC0308Key, C03141 c03141) {
                this(abstractC0308Key);
            }

            public KeyStatus getStatus() {
                return this.keyStatus;
            }

            public boolean isPrimary() {
                return this.isPrimary;
            }

            public Entry makePrimary() {
                C0315Builder c0315Builder = this.f3002builder;
                if (c0315Builder != null) {
                    c0315Builder.clearPrimary();
                }
                this.isPrimary = true;
                return this;
            }

            public Entry setStatus(KeyStatus keyStatus) {
                this.keyStatus = keyStatus;
                return this;
            }

            public Entry withFixedId(int i) {
                this.strategy = KeyIdStrategy.m3359fixedId(i);
                return this;
            }

            public Entry withRandomId() {
                this.strategy = KeyIdStrategy.randomId();
                return this;
            }

            public /* synthetic */ Entry(Parameters parameters, C03141 c03141) {
                this(parameters);
            }

            private Entry(AbstractC0308Key abstractC0308Key) {
                this.keyStatus = KeyStatus.f2991ENABLED;
                this.strategy = null;
                this.f3002builder = null;
                this.f3003key = abstractC0308Key;
                this.parameters = null;
            }

            private Entry(Parameters parameters) {
                this.keyStatus = KeyStatus.f2991ENABLED;
                this.strategy = null;
                this.f3002builder = null;
                this.f3003key = null;
                this.parameters = parameters;
            }
        }

        private static void checkIdAssignments(List<Entry> list) throws GeneralSecurityException {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).strategy == KeyIdStrategy.RANDOM_ID && list.get(i + 1).strategy != KeyIdStrategy.RANDOM_ID) {
                    throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPrimary() {
            Iterator<Entry> it = this.f3001entries.iterator();
            while (it.hasNext()) {
                it.next().isPrimary = false;
            }
        }

        private static C0675Keyset.Key createKeyFromParameters(Parameters parameters, int i, KeyStatusType keyStatusType) {
            ProtoParametersSerialization serialization = parameters instanceof LegacyProtoParameters ? ((LegacyProtoParameters) parameters).getSerialization() : (ProtoParametersSerialization) MutableSerializationRegistry.globalInstance().serializeParameters(parameters, ProtoParametersSerialization.class);
            return C0675Keyset.Key.newBuilder().setKeyId(i).setStatus(keyStatusType).setKeyData(Registry.newKeyData(serialization.getKeyTemplate())).setOutputPrefixType(serialization.getKeyTemplate().getOutputPrefixType()).mo3555build();
        }

        private static C0675Keyset.Key createKeysetKeyFromBuilderEntry(Entry entry, int i) throws GeneralSecurityException {
            if (entry.f3003key == null) {
                return createKeyFromParameters(entry.parameters, i, KeysetHandle.serializeStatus(entry.getStatus()));
            }
            ProtoKeySerialization serialization = entry.f3003key instanceof LegacyProtoKey ? ((LegacyProtoKey) entry.f3003key).getSerialization(InsecureSecretKeyAccess.m3332get()) : (ProtoKeySerialization) MutableSerializationRegistry.globalInstance().serializeKey(entry.f3003key, ProtoKeySerialization.class, InsecureSecretKeyAccess.m3332get());
            Integer idRequirementOrNull = serialization.getIdRequirementOrNull();
            if (idRequirementOrNull == null || idRequirementOrNull.intValue() == i) {
                return KeysetHandle.toKeysetKey(i, KeysetHandle.serializeStatus(entry.getStatus()), serialization);
            }
            throw new GeneralSecurityException("Wrong ID set for key with ID requirement");
        }

        private static int getNextIdFromBuilderEntry(Entry entry, Set<Integer> set) throws GeneralSecurityException {
            if (entry.strategy != null) {
                return entry.strategy == KeyIdStrategy.RANDOM_ID ? randomIdNotInSet(set) : entry.strategy.getFixedId();
            }
            throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
        }

        private static int randomIdNotInSet(Set<Integer> set) {
            int iRandKeyId = 0;
            while (true) {
                if (iRandKeyId != 0 && !set.contains(Integer.valueOf(iRandKeyId))) {
                    return iRandKeyId;
                }
                iRandKeyId = C0431Util.randKeyId();
            }
        }

        public C0315Builder addEntry(Entry entry) {
            if (entry.f3002builder != null) {
                throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
            }
            if (entry.isPrimary) {
                clearPrimary();
            }
            entry.f3002builder = this;
            this.f3001entries.add(entry);
            return this;
        }

        /* renamed from: build */
        public KeysetHandle m3356build() throws GeneralSecurityException {
            C0675Keyset.Builder builderNewBuilder = C0675Keyset.newBuilder();
            checkIdAssignments(this.f3001entries);
            HashSet hashSet = new HashSet();
            Integer numValueOf = null;
            for (Entry entry : this.f3001entries) {
                if (entry.keyStatus == null) {
                    throw new GeneralSecurityException("Key Status not set.");
                }
                int nextIdFromBuilderEntry = getNextIdFromBuilderEntry(entry, hashSet);
                if (hashSet.contains(Integer.valueOf(nextIdFromBuilderEntry))) {
                    throw new GeneralSecurityException("Id " + nextIdFromBuilderEntry + " is used twice in the keyset");
                }
                hashSet.add(Integer.valueOf(nextIdFromBuilderEntry));
                builderNewBuilder.m3804addKey(createKeysetKeyFromBuilderEntry(entry, nextIdFromBuilderEntry));
                if (entry.isPrimary) {
                    if (numValueOf != null) {
                        throw new GeneralSecurityException("Two primaries were set");
                    }
                    numValueOf = Integer.valueOf(nextIdFromBuilderEntry);
                }
            }
            if (numValueOf == null) {
                throw new GeneralSecurityException("No primary was set");
            }
            builderNewBuilder.setPrimaryKeyId(numValueOf.intValue());
            return KeysetHandle.fromKeyset(builderNewBuilder.mo3555build());
        }

        public C0315Builder deleteAt(int i) {
            this.f3001entries.remove(i);
            return this;
        }

        /* renamed from: getAt */
        public Entry m3357getAt(int i) {
            return this.f3001entries.get(i);
        }

        @Deprecated
        public Entry removeAt(int i) {
            return this.f3001entries.remove(i);
        }

        /* renamed from: size */
        public int m3358size() {
            return this.f3001entries.size();
        }

        /* renamed from: com.google.crypto.tink.KeysetHandle$Builder$KeyIdStrategy */
        public static class KeyIdStrategy {
            private static final KeyIdStrategy RANDOM_ID = new KeyIdStrategy();

            /* renamed from: fixedId */
            private final int f3004fixedId;

            private KeyIdStrategy() {
                this.f3004fixedId = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: fixedId */
            public static KeyIdStrategy m3359fixedId(int i) {
                return new KeyIdStrategy(i);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int getFixedId() {
                return this.f3004fixedId;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static KeyIdStrategy randomId() {
                return RANDOM_ID;
            }

            private KeyIdStrategy(int i) {
                this.f3004fixedId = i;
            }
        }
    }

    @InterfaceC0389Alpha
    /* renamed from: com.google.crypto.tink.KeysetHandle$Entry */
    public static final class C0316Entry {

        /* renamed from: id */
        private final int f3005id;
        private final boolean isPrimary;

        /* renamed from: key */
        private final AbstractC0308Key f3006key;
        private final KeyStatus keyStatus;

        public /* synthetic */ C0316Entry(AbstractC0308Key abstractC0308Key, KeyStatus keyStatus, int i, boolean z, C03141 c03141) {
            this(abstractC0308Key, keyStatus, i, z);
        }

        /* renamed from: getId */
        public int m3360getId() {
            return this.f3005id;
        }

        /* renamed from: getKey */
        public AbstractC0308Key m3361getKey() {
            return this.f3006key;
        }

        public KeyStatus getStatus() {
            return this.keyStatus;
        }

        public boolean isPrimary() {
            return this.isPrimary;
        }

        private C0316Entry(AbstractC0308Key abstractC0308Key, KeyStatus keyStatus, int i, boolean z) {
            this.f3006key = abstractC0308Key;
            this.keyStatus = keyStatus;
            this.f3005id = i;
            this.isPrimary = z;
        }
    }

    private KeysetHandle(C0675Keyset c0675Keyset, List<C0316Entry> list) {
        this.f3000keyset = c0675Keyset;
        this.f2999entries = list;
        this.annotations = MonitoringAnnotations.f3183EMPTY;
    }

    private static void assertEnoughEncryptedKeyMaterial(EncryptedKeyset encryptedKeyset) throws GeneralSecurityException {
        if (encryptedKeyset == null || encryptedKeyset.getEncryptedKeyset().mo3944size() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    private static void assertEnoughKeyMaterial(C0675Keyset c0675Keyset) throws GeneralSecurityException {
        if (c0675Keyset == null || c0675Keyset.getKeyCount() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    private static void assertNoSecretKeyMaterial(C0675Keyset c0675Keyset) throws GeneralSecurityException {
        for (C0675Keyset.Key key : c0675Keyset.getKeyList()) {
            if (key.getKeyData().getKeyMaterialType() == C0669KeyData.KeyMaterialType.UNKNOWN_KEYMATERIAL || key.getKeyData().getKeyMaterialType() == C0669KeyData.KeyMaterialType.SYMMETRIC || key.getKeyData().getKeyMaterialType() == C0669KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE) {
                throw new GeneralSecurityException(String.format("keyset contains key material of type %s for type url %s", key.getKeyData().getKeyMaterialType().name(), key.getKeyData().getTypeUrl()));
            }
        }
    }

    @Deprecated
    public static final KeysetHandle createFromKey(KeyHandle keyHandle, KeyAccess keyAccess) {
        KeysetManager keysetManagerM3365add = KeysetManager.withEmptyKeyset().m3365add(keyHandle);
        keysetManagerM3365add.setPrimary(keysetManagerM3365add.getKeysetHandle().getKeysetInfo().getKeyInfo(0).getKeyId());
        return keysetManagerM3365add.getKeysetHandle();
    }

    private static C0669KeyData createPublicKeyData(C0669KeyData c0669KeyData) throws GeneralSecurityException {
        if (c0669KeyData.getKeyMaterialType() != C0669KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE) {
            throw new GeneralSecurityException("The keyset contains a non-private key");
        }
        C0669KeyData publicKeyData = Registry.getPublicKeyData(c0669KeyData.getTypeUrl(), c0669KeyData.getValue());
        validate(publicKeyData);
        return publicKeyData;
    }

    /* renamed from: decrypt */
    private static C0675Keyset m3349decrypt(EncryptedKeyset encryptedKeyset, InterfaceC0305Aead interfaceC0305Aead, byte[] bArr) throws GeneralSecurityException {
        try {
            C0675Keyset from = C0675Keyset.parseFrom(interfaceC0305Aead.mo3322decrypt(encryptedKeyset.getEncryptedKeyset().toByteArray(), bArr), ExtensionRegistryLite.getEmptyRegistry());
            assertEnoughKeyMaterial(from);
            return from;
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    /* renamed from: encrypt */
    private static EncryptedKeyset m3350encrypt(C0675Keyset c0675Keyset, InterfaceC0305Aead interfaceC0305Aead, byte[] bArr) throws GeneralSecurityException {
        byte[] bArrMo3323encrypt = interfaceC0305Aead.mo3323encrypt(c0675Keyset.toByteArray(), bArr);
        try {
            if (C0675Keyset.parseFrom(interfaceC0305Aead.mo3322decrypt(bArrMo3323encrypt, bArr), ExtensionRegistryLite.getEmptyRegistry()).m4025equals(c0675Keyset)) {
                return EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(bArrMo3323encrypt)).setKeysetInfo(C0323Util.getKeysetInfo(c0675Keyset)).mo3555build();
            }
            throw new GeneralSecurityException("cannot encrypt keyset");
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    private C0316Entry entryByIndex(int i) {
        if (this.f2999entries.get(i) != null) {
            return this.f2999entries.get(i);
        }
        throw new IllegalStateException("Keyset-Entry at position i has wrong status or key parsing failed");
    }

    public static final KeysetHandle fromKeyset(C0675Keyset c0675Keyset) throws GeneralSecurityException {
        assertEnoughKeyMaterial(c0675Keyset);
        return new KeysetHandle(c0675Keyset, getEntriesFromKeyset(c0675Keyset));
    }

    public static final KeysetHandle fromKeysetAndAnnotations(C0675Keyset c0675Keyset, MonitoringAnnotations monitoringAnnotations) throws GeneralSecurityException {
        assertEnoughKeyMaterial(c0675Keyset);
        return new KeysetHandle(c0675Keyset, getEntriesFromKeyset(c0675Keyset), monitoringAnnotations);
    }

    public static C0315Builder.Entry generateEntryFromParameters(Parameters parameters) {
        return new C0315Builder.Entry(parameters, (C03141) null);
    }

    public static C0315Builder.Entry generateEntryFromParametersName(String str) throws GeneralSecurityException {
        if (Registry.keyTemplateMap().containsKey(str)) {
            return new C0315Builder.Entry(MutableSerializationRegistry.globalInstance().parseParametersWithLegacyFallback(ProtoParametersSerialization.m3500create(Registry.keyTemplateMap().get(str).getProto())), (C03141) null);
        }
        throw new GeneralSecurityException("cannot find key template: " + str);
    }

    @Deprecated
    public static final KeysetHandle generateNew(KeyTemplate keyTemplate) {
        return newBuilder().addEntry(generateEntryFromParameters(new LegacyProtoParameters(ProtoParametersSerialization.m3500create(keyTemplate))).makePrimary().withRandomId()).m3356build();
    }

    private static List<C0316Entry> getEntriesFromKeyset(C0675Keyset c0675Keyset) {
        ArrayList arrayList = new ArrayList(c0675Keyset.getKeyCount());
        for (C0675Keyset.Key key : c0675Keyset.getKeyList()) {
            int keyId = key.getKeyId();
            try {
                arrayList.add(new C0316Entry(MutableSerializationRegistry.globalInstance().parseKeyWithLegacyFallback(toProtoKeySerialization(key), InsecureSecretKeyAccess.m3332get()), parseStatus(key.getStatus()), keyId, keyId == c0675Keyset.getPrimaryKeyId(), null));
            } catch (GeneralSecurityException unused) {
                arrayList.add(null);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Nullable
    private <B> B getFullPrimitiveOrNull(AbstractC0308Key abstractC0308Key, Class<B> cls) {
        try {
            return (B) Registry.getFullPrimitive(abstractC0308Key, cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    @Nullable
    private static <B> B getLegacyPrimitiveOrNull(C0675Keyset.Key key, Class<B> cls) throws GeneralSecurityException {
        try {
            return (B) Registry.getPrimitive(key.getKeyData(), cls);
        } catch (GeneralSecurityException e) {
            if (e.getMessage().contains("No key manager found for key type ") || e.getMessage().contains(" not supported by key manager of type ")) {
                return null;
            }
            throw e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <B, P> P getPrimitiveWithKnownInputPrimitive(Class<P> cls, Class<B> cls2) throws GeneralSecurityException {
        C0323Util.validateKeyset(this.f3000keyset);
        PrimitiveSet.C0319Builder c0319BuilderNewBuilder = PrimitiveSet.newBuilder(cls2);
        c0319BuilderNewBuilder.setAnnotations(this.annotations);
        for (int i = 0; i < m3354size(); i++) {
            C0675Keyset.Key keyMo3800getKey = this.f3000keyset.mo3800getKey(i);
            if (keyMo3800getKey.getStatus().equals(KeyStatusType.ENABLED)) {
                Object legacyPrimitiveOrNull = getLegacyPrimitiveOrNull(keyMo3800getKey, cls2);
                Object fullPrimitiveOrNull = this.f2999entries.get(i) != null ? getFullPrimitiveOrNull(this.f2999entries.get(i).m3361getKey(), cls2) : null;
                if (keyMo3800getKey.getKeyId() == this.f3000keyset.getPrimaryKeyId()) {
                    c0319BuilderNewBuilder.addPrimaryFullPrimitiveAndOptionalPrimitive(fullPrimitiveOrNull, legacyPrimitiveOrNull, keyMo3800getKey);
                } else {
                    c0319BuilderNewBuilder.addFullPrimitiveAndOptionalPrimitive(fullPrimitiveOrNull, legacyPrimitiveOrNull, keyMo3800getKey);
                }
            }
        }
        return (P) Registry.m3392wrap(c0319BuilderNewBuilder.m3382build(), cls);
    }

    public static C0315Builder.Entry importKey(AbstractC0308Key abstractC0308Key) {
        C0315Builder.Entry entry = new C0315Builder.Entry(abstractC0308Key, (C03141) null);
        Integer idRequirementOrNull = abstractC0308Key.getIdRequirementOrNull();
        if (idRequirementOrNull != null) {
            entry.withFixedId(idRequirementOrNull.intValue());
        }
        return entry;
    }

    public static C0315Builder newBuilder() {
        return new C0315Builder();
    }

    private static KeyStatus parseStatus(KeyStatusType keyStatusType) throws GeneralSecurityException {
        int i = C03141.$SwitchMap$com$google$crypto$tink$proto$KeyStatusType[keyStatusType.ordinal()];
        if (i == 1) {
            return KeyStatus.f2991ENABLED;
        }
        if (i == 2) {
            return KeyStatus.DISABLED;
        }
        if (i == 3) {
            return KeyStatus.DESTROYED;
        }
        throw new GeneralSecurityException("Unknown key status");
    }

    /* renamed from: read */
    public static final KeysetHandle m3351read(KeysetReader keysetReader, InterfaceC0305Aead interfaceC0305Aead) {
        return readWithAssociatedData(keysetReader, interfaceC0305Aead, new byte[0]);
    }

    public static final KeysetHandle readNoSecret(KeysetReader keysetReader) throws GeneralSecurityException {
        try {
            C0675Keyset c0675KeysetMo3324read = keysetReader.mo3324read();
            assertNoSecretKeyMaterial(c0675KeysetMo3324read);
            return fromKeyset(c0675KeysetMo3324read);
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    public static final KeysetHandle readWithAssociatedData(KeysetReader keysetReader, InterfaceC0305Aead interfaceC0305Aead, byte[] bArr) throws GeneralSecurityException {
        EncryptedKeyset encrypted = keysetReader.readEncrypted();
        assertEnoughEncryptedKeyMaterial(encrypted);
        return fromKeyset(m3349decrypt(encrypted, interfaceC0305Aead, bArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyStatusType serializeStatus(KeyStatus keyStatus) {
        if (KeyStatus.f2991ENABLED.equals(keyStatus)) {
            return KeyStatusType.ENABLED;
        }
        if (KeyStatus.DISABLED.equals(keyStatus)) {
            return KeyStatusType.DISABLED;
        }
        if (KeyStatus.DESTROYED.equals(keyStatus)) {
            return KeyStatusType.DESTROYED;
        }
        throw new IllegalStateException("Unknown key status");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C0675Keyset.Key toKeysetKey(int i, KeyStatusType keyStatusType, ProtoKeySerialization protoKeySerialization) {
        return C0675Keyset.Key.newBuilder().setKeyData(C0669KeyData.newBuilder().setTypeUrl(protoKeySerialization.getTypeUrl()).setValue(protoKeySerialization.getValue()).setKeyMaterialType(protoKeySerialization.getKeyMaterialType())).setStatus(keyStatusType).setKeyId(i).setOutputPrefixType(protoKeySerialization.getOutputPrefixType()).mo3555build();
    }

    private static ProtoKeySerialization toProtoKeySerialization(C0675Keyset.Key key) {
        try {
            return ProtoKeySerialization.m3499create(key.getKeyData().getTypeUrl(), key.getKeyData().getValue(), key.getKeyData().getKeyMaterialType(), key.getOutputPrefixType(), key.getOutputPrefixType() == OutputPrefixType.RAW ? null : Integer.valueOf(key.getKeyId()));
        } catch (GeneralSecurityException e) {
            throw new TinkBugException("Creating a protokey serialization failed", e);
        }
    }

    private static void validate(C0669KeyData c0669KeyData) {
        Registry.getPrimitive(c0669KeyData);
    }

    /* renamed from: getAt */
    public C0316Entry m3352getAt(int i) {
        if (i >= 0 && i < m3354size()) {
            return entryByIndex(i);
        }
        throw new IndexOutOfBoundsException("Invalid index " + i + " for keyset of size " + m3354size());
    }

    @Deprecated
    /* renamed from: getKeys */
    public List<KeyHandle> m3353getKeys() {
        ArrayList arrayList = new ArrayList();
        for (C0675Keyset.Key key : this.f3000keyset.getKeyList()) {
            arrayList.add(new InternalKeyHandle(new ProtoKey(key.getKeyData(), KeyTemplate.fromProto(key.getOutputPrefixType())), key.getStatus(), key.getKeyId()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public C0675Keyset getKeyset() {
        return this.f3000keyset;
    }

    public KeysetInfo getKeysetInfo() {
        return C0323Util.getKeysetInfo(this.f3000keyset);
    }

    public C0316Entry getPrimary() {
        for (int i = 0; i < this.f3000keyset.getKeyCount(); i++) {
            if (this.f3000keyset.mo3800getKey(i).getKeyId() == this.f3000keyset.getPrimaryKeyId()) {
                C0316Entry c0316EntryEntryByIndex = entryByIndex(i);
                if (c0316EntryEntryByIndex.getStatus() == KeyStatus.f2991ENABLED) {
                    return c0316EntryEntryByIndex;
                }
                throw new IllegalStateException("Keyset has primary which isn't enabled");
            }
        }
        throw new IllegalStateException("Keyset has no primary");
    }

    public <P> P getPrimitive(Class<P> cls) throws GeneralSecurityException {
        Class<?> inputPrimitive = Registry.getInputPrimitive(cls);
        if (inputPrimitive != null) {
            return (P) getPrimitiveWithKnownInputPrimitive(cls, inputPrimitive);
        }
        throw new GeneralSecurityException("No wrapper found for " + cls.getName());
    }

    public KeysetHandle getPublicKeysetHandle() throws GeneralSecurityException {
        if (this.f3000keyset == null) {
            throw new GeneralSecurityException("cleartext keyset is not available");
        }
        C0675Keyset.Builder builderNewBuilder = C0675Keyset.newBuilder();
        for (C0675Keyset.Key key : this.f3000keyset.getKeyList()) {
            builderNewBuilder.m3804addKey(key.toBuilder().setKeyData(createPublicKeyData(key.getKeyData())).mo3555build());
        }
        builderNewBuilder.setPrimaryKeyId(this.f3000keyset.getPrimaryKeyId());
        return fromKeyset(builderNewBuilder.mo3555build());
    }

    @Deprecated
    public KeyHandle primaryKey() throws GeneralSecurityException {
        int primaryKeyId = this.f3000keyset.getPrimaryKeyId();
        for (C0675Keyset.Key key : this.f3000keyset.getKeyList()) {
            if (key.getKeyId() == primaryKeyId) {
                return new InternalKeyHandle(new ProtoKey(key.getKeyData(), KeyTemplate.fromProto(key.getOutputPrefixType())), key.getStatus(), key.getKeyId());
            }
        }
        throw new GeneralSecurityException("No primary key found in keyset.");
    }

    /* renamed from: size */
    public int m3354size() {
        return this.f3000keyset.getKeyCount();
    }

    public String toString() {
        return getKeysetInfo().toString();
    }

    /* renamed from: write */
    public void m3355write(KeysetWriter keysetWriter, InterfaceC0305Aead interfaceC0305Aead) {
        writeWithAssociatedData(keysetWriter, interfaceC0305Aead, new byte[0]);
    }

    public void writeNoSecret(KeysetWriter keysetWriter) throws GeneralSecurityException {
        assertNoSecretKeyMaterial(this.f3000keyset);
        keysetWriter.mo3326write(this.f3000keyset);
    }

    public void writeWithAssociatedData(KeysetWriter keysetWriter, InterfaceC0305Aead interfaceC0305Aead, byte[] bArr) {
        keysetWriter.mo3325write(m3350encrypt(this.f3000keyset, interfaceC0305Aead, bArr));
    }

    public static C0315Builder newBuilder(KeysetHandle keysetHandle) {
        C0315Builder c0315Builder = new C0315Builder();
        for (int i = 0; i < keysetHandle.m3354size(); i++) {
            C0316Entry c0316EntryEntryByIndex = keysetHandle.entryByIndex(i);
            C0315Builder.Entry entryWithFixedId = importKey(c0316EntryEntryByIndex.m3361getKey()).withFixedId(c0316EntryEntryByIndex.m3360getId());
            entryWithFixedId.setStatus(c0316EntryEntryByIndex.getStatus());
            if (c0316EntryEntryByIndex.isPrimary()) {
                entryWithFixedId.makePrimary();
            }
            c0315Builder.addEntry(entryWithFixedId);
        }
        return c0315Builder;
    }

    private KeysetHandle(C0675Keyset c0675Keyset, List<C0316Entry> list, MonitoringAnnotations monitoringAnnotations) {
        this.f3000keyset = c0675Keyset;
        this.f2999entries = list;
        this.annotations = monitoringAnnotations;
    }

    @Deprecated
    public static final KeysetHandle readNoSecret(byte[] bArr) throws GeneralSecurityException {
        try {
            C0675Keyset from = C0675Keyset.parseFrom(bArr, ExtensionRegistryLite.getEmptyRegistry());
            assertNoSecretKeyMaterial(from);
            return fromKeyset(from);
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    public static final KeysetHandle generateNew(KeyTemplate keyTemplate) {
        return newBuilder().addEntry(generateEntryFromParameters(new LegacyProtoParameters(ProtoParametersSerialization.m3500create(keyTemplate.getProto()))).makePrimary().withRandomId()).m3356build();
    }
}
