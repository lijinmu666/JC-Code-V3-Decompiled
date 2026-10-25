package com.p038google.p061crypto.p062tink;

import com.p038google.p061crypto.p062tink.internal.MutableSerializationRegistry;
import com.p038google.p061crypto.p062tink.internal.ProtoKeySerialization;
import com.p038google.p061crypto.p062tink.monitoring.MonitoringAnnotations;
import com.p038google.p061crypto.p062tink.p073proto.C0675Keyset;
import com.p038google.p061crypto.p062tink.p073proto.KeyStatusType;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;
import com.p038google.p061crypto.p062tink.p075subtle.C0865Hex;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class PrimitiveSet<P> {
    private final MonitoringAnnotations annotations;
    private final boolean isMutable;

    /* renamed from: primary */
    private C0320Entry<P> f3014primary;
    private final Class<P> primitiveClass;
    private final ConcurrentMap<C0321Prefix, List<C0320Entry<P>>> primitives;

    /* renamed from: com.google.crypto.tink.PrimitiveSet$Builder */
    public static class C0319Builder<P> {
        private MonitoringAnnotations annotations;

        /* renamed from: primary */
        private C0320Entry<P> f3015primary;
        private final Class<P> primitiveClass;
        private ConcurrentMap<C0321Prefix, List<C0320Entry<P>>> primitives;

        private C0319Builder<P> addPrimitive(@Nullable P p, @Nullable P p2, C0675Keyset.Key key, boolean z) throws GeneralSecurityException {
            if (this.primitives == null) {
                throw new IllegalStateException("addPrimitive cannot be called after build");
            }
            if (p == null && p2 == null) {
                throw new GeneralSecurityException("at least one of the `fullPrimitive` or `primitive` must be set");
            }
            if (key.getStatus() != KeyStatusType.ENABLED) {
                throw new GeneralSecurityException("only ENABLED key is allowed");
            }
            C0320Entry<P> c0320EntryAddEntryToMap = PrimitiveSet.addEntryToMap(p, p2, key, this.primitives);
            if (z) {
                if (this.f3015primary != null) {
                    throw new IllegalStateException("you cannot set two primary primitives");
                }
                this.f3015primary = c0320EntryAddEntryToMap;
            }
            return this;
        }

        public C0319Builder<P> addFullPrimitiveAndOptionalPrimitive(@Nullable P p, @Nullable P p2, C0675Keyset.Key key) {
            return addPrimitive(p, p2, key, false);
        }

        public C0319Builder<P> addPrimaryFullPrimitiveAndOptionalPrimitive(@Nullable P p, @Nullable P p2, C0675Keyset.Key key) {
            return addPrimitive(p, p2, key, true);
        }

        public C0319Builder<P> addPrimaryPrimitive(P p, C0675Keyset.Key key) {
            return addPrimitive(null, p, key, true);
        }

        /* renamed from: build */
        public PrimitiveSet<P> m3382build() {
            ConcurrentMap<C0321Prefix, List<C0320Entry<P>>> concurrentMap = this.primitives;
            if (concurrentMap == null) {
                throw new IllegalStateException("build cannot be called twice");
            }
            PrimitiveSet<P> primitiveSet = new PrimitiveSet<>(concurrentMap, this.f3015primary, this.annotations, this.primitiveClass);
            this.primitives = null;
            return primitiveSet;
        }

        public C0319Builder<P> setAnnotations(MonitoringAnnotations monitoringAnnotations) {
            if (this.primitives == null) {
                throw new IllegalStateException("setAnnotations cannot be called after build");
            }
            this.annotations = monitoringAnnotations;
            return this;
        }

        private C0319Builder(Class<P> cls) {
            this.primitives = new ConcurrentHashMap();
            this.primitiveClass = cls;
            this.annotations = MonitoringAnnotations.f3183EMPTY;
        }

        public C0319Builder<P> addPrimitive(P p, C0675Keyset.Key key) {
            return addPrimitive(null, p, key, false);
        }
    }

    /* renamed from: com.google.crypto.tink.PrimitiveSet$Entry */
    public static final class C0320Entry<P> {

        @Nullable
        private final P fullPrimitive;
        private final byte[] identifier;

        /* renamed from: key */
        private final AbstractC0308Key f3016key;

        /* renamed from: keyId */
        private final int f3017keyId;

        /* renamed from: keyType */
        private final String f3018keyType;
        private final OutputPrefixType outputPrefixType;

        @Nullable
        private final P primitive;

        /* renamed from: status */
        private final KeyStatusType f3019status;

        public C0320Entry(@Nullable P p, @Nullable P p2, byte[] bArr, KeyStatusType keyStatusType, OutputPrefixType outputPrefixType, int i, String str, AbstractC0308Key abstractC0308Key) {
            this.fullPrimitive = p;
            this.primitive = p2;
            this.identifier = Arrays.copyOf(bArr, bArr.length);
            this.f3019status = keyStatusType;
            this.outputPrefixType = outputPrefixType;
            this.f3017keyId = i;
            this.f3018keyType = str;
            this.f3016key = abstractC0308Key;
        }

        @Nullable
        public P getFullPrimitive() {
            return this.fullPrimitive;
        }

        @Nullable
        public final byte[] getIdentifier() {
            byte[] bArr = this.identifier;
            if (bArr == null) {
                return null;
            }
            return Arrays.copyOf(bArr, bArr.length);
        }

        /* renamed from: getKey */
        public AbstractC0308Key m3383getKey() {
            return this.f3016key;
        }

        public int getKeyId() {
            return this.f3017keyId;
        }

        public String getKeyType() {
            return this.f3018keyType;
        }

        public OutputPrefixType getOutputPrefixType() {
            return this.outputPrefixType;
        }

        @Nullable
        public Parameters getParameters() {
            AbstractC0308Key abstractC0308Key = this.f3016key;
            if (abstractC0308Key == null) {
                return null;
            }
            return abstractC0308Key.getParameters();
        }

        @Nullable
        public P getPrimitive() {
            return this.primitive;
        }

        public KeyStatusType getStatus() {
            return this.f3019status;
        }
    }

    /* renamed from: com.google.crypto.tink.PrimitiveSet$Prefix */
    public static class C0321Prefix implements Comparable<C0321Prefix> {

        /* renamed from: prefix */
        private final byte[] f3020prefix;

        /* renamed from: equals */
        public boolean m3384equals(Object obj) {
            if (obj instanceof C0321Prefix) {
                return Arrays.equals(this.f3020prefix, ((C0321Prefix) obj).f3020prefix);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f3020prefix);
        }

        public String toString() {
            return C0865Hex.m4275encode(this.f3020prefix);
        }

        private C0321Prefix(byte[] bArr) {
            this.f3020prefix = Arrays.copyOf(bArr, bArr.length);
        }

        @Override // java.lang.Comparable
        public int compareTo(C0321Prefix c0321Prefix) {
            byte[] bArr = this.f3020prefix;
            int length = bArr.length;
            byte[] bArr2 = c0321Prefix.f3020prefix;
            if (length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            int i = 0;
            while (true) {
                byte[] bArr3 = this.f3020prefix;
                if (i >= bArr3.length) {
                    return 0;
                }
                byte b = bArr3[i];
                byte b2 = c0321Prefix.f3020prefix[i];
                if (b != b2) {
                    return b - b2;
                }
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <P> C0320Entry<P> addEntryToMap(@Nullable P p, @Nullable P p2, C0675Keyset.Key key, ConcurrentMap<C0321Prefix, List<C0320Entry<P>>> concurrentMap) {
        Integer numValueOf = Integer.valueOf(key.getKeyId());
        if (key.getOutputPrefixType() == OutputPrefixType.RAW) {
            numValueOf = null;
        }
        C0320Entry<P> c0320Entry = new C0320Entry<>(p, p2, CryptoFormat.getOutputPrefix(key), key.getStatus(), key.getOutputPrefixType(), key.getKeyId(), key.getKeyData().getTypeUrl(), MutableSerializationRegistry.globalInstance().parseKeyWithLegacyFallback(ProtoKeySerialization.m3499create(key.getKeyData().getTypeUrl(), key.getKeyData().getValue(), key.getKeyData().getKeyMaterialType(), key.getOutputPrefixType(), numValueOf), InsecureSecretKeyAccess.m3332get()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(c0320Entry);
        C0321Prefix c0321Prefix = new C0321Prefix(c0320Entry.getIdentifier());
        List<C0320Entry<P>> listPut = concurrentMap.put(c0321Prefix, Collections.unmodifiableList(arrayList));
        if (listPut != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(listPut);
            arrayList2.add(c0320Entry);
            concurrentMap.put(c0321Prefix, Collections.unmodifiableList(arrayList2));
        }
        return c0320Entry;
    }

    public static <P> C0319Builder<P> newBuilder(Class<P> cls) {
        return new C0319Builder<>(cls);
    }

    @Deprecated
    public static <P> PrimitiveSet<P> newPrimitiveSet(Class<P> cls) {
        return new PrimitiveSet<>(cls);
    }

    @Deprecated
    public C0320Entry<P> addPrimitive(P p, C0675Keyset.Key key) throws GeneralSecurityException {
        if (!this.isMutable) {
            throw new IllegalStateException("addPrimitive cannot be called on an immutable primitive set");
        }
        if (key.getStatus() == KeyStatusType.ENABLED) {
            return addEntryToMap(null, p, key, this.primitives);
        }
        throw new GeneralSecurityException("only ENABLED key is allowed");
    }

    /* renamed from: getAll */
    public Collection<List<C0320Entry<P>>> m3381getAll() {
        return this.primitives.values();
    }

    public MonitoringAnnotations getAnnotations() {
        return this.annotations;
    }

    @Nullable
    public C0320Entry<P> getPrimary() {
        return this.f3014primary;
    }

    public List<C0320Entry<P>> getPrimitive(byte[] bArr) {
        List<C0320Entry<P>> list = this.primitives.get(new C0321Prefix(bArr));
        return list != null ? list : Collections.emptyList();
    }

    public Class<P> getPrimitiveClass() {
        return this.primitiveClass;
    }

    public List<C0320Entry<P>> getRawPrimitives() {
        return getPrimitive(CryptoFormat.RAW_PREFIX);
    }

    public boolean hasAnnotations() {
        return !this.annotations.m3534toMap().isEmpty();
    }

    @Deprecated
    public void setPrimary(C0320Entry<P> c0320Entry) {
        if (!this.isMutable) {
            throw new IllegalStateException("setPrimary cannot be called on an immutable primitive set");
        }
        if (c0320Entry == null) {
            throw new IllegalArgumentException("the primary entry must be non-null");
        }
        if (c0320Entry.getStatus() != KeyStatusType.ENABLED) {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        }
        if (getPrimitive(c0320Entry.getIdentifier()).isEmpty()) {
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        }
        this.f3014primary = c0320Entry;
    }

    private PrimitiveSet(Class<P> cls) {
        this.primitives = new ConcurrentHashMap();
        this.primitiveClass = cls;
        this.annotations = MonitoringAnnotations.f3183EMPTY;
        this.isMutable = true;
    }

    private PrimitiveSet(ConcurrentMap<C0321Prefix, List<C0320Entry<P>>> concurrentMap, C0320Entry<P> c0320Entry, MonitoringAnnotations monitoringAnnotations, Class<P> cls) {
        this.primitives = concurrentMap;
        this.f3014primary = c0320Entry;
        this.primitiveClass = cls;
        this.annotations = monitoringAnnotations;
        this.isMutable = false;
    }
}
