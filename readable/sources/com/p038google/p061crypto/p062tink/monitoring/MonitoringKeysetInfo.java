package com.p038google.p061crypto.p062tink.monitoring;

import com.p038google.p061crypto.p062tink.KeyStatus;
import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@InterfaceC0389Alpha
/* loaded from: classes.dex */
public final class MonitoringKeysetInfo {
    private final MonitoringAnnotations annotations;

    /* renamed from: entries */
    private final List<C0488Entry> f3185entries;

    @Nullable
    private final Integer primaryKeyId;

    /* renamed from: com.google.crypto.tink.monitoring.MonitoringKeysetInfo$Builder */
    public static final class C0487Builder {

        @Nullable
        private ArrayList<C0488Entry> builderEntries = new ArrayList<>();
        private MonitoringAnnotations builderAnnotations = MonitoringAnnotations.f3183EMPTY;

        @Nullable
        private Integer builderPrimaryKeyId = null;

        private boolean isKeyIdInEntries(int i) {
            Iterator<C0488Entry> it = this.builderEntries.iterator();
            while (it.hasNext()) {
                if (it.next().getKeyId() == i) {
                    return true;
                }
            }
            return false;
        }

        public C0487Builder addEntry(KeyStatus keyStatus, int i, String str, String str2) {
            ArrayList<C0488Entry> arrayList = this.builderEntries;
            if (arrayList == null) {
                throw new IllegalStateException("addEntry cannot be called after build()");
            }
            arrayList.add(new C0488Entry(keyStatus, i, str, str2));
            return this;
        }

        /* renamed from: build */
        public MonitoringKeysetInfo m3539build() throws GeneralSecurityException {
            if (this.builderEntries == null) {
                throw new IllegalStateException("cannot call build() twice");
            }
            Integer num = this.builderPrimaryKeyId;
            if (num != null && !isKeyIdInEntries(num.intValue())) {
                throw new GeneralSecurityException("primary key ID is not present in entries");
            }
            MonitoringKeysetInfo monitoringKeysetInfo = new MonitoringKeysetInfo(this.builderAnnotations, Collections.unmodifiableList(this.builderEntries), this.builderPrimaryKeyId);
            this.builderEntries = null;
            return monitoringKeysetInfo;
        }

        public C0487Builder setAnnotations(MonitoringAnnotations monitoringAnnotations) {
            if (this.builderEntries == null) {
                throw new IllegalStateException("setAnnotations cannot be called after build()");
            }
            this.builderAnnotations = monitoringAnnotations;
            return this;
        }

        public C0487Builder setPrimaryKeyId(int i) {
            if (this.builderEntries == null) {
                throw new IllegalStateException("setPrimaryKeyId cannot be called after build()");
            }
            this.builderPrimaryKeyId = Integer.valueOf(i);
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.monitoring.MonitoringKeysetInfo$Entry */
    public static final class C0488Entry {

        /* renamed from: keyId */
        private final int f3186keyId;
        private final String keyPrefix;

        /* renamed from: keyType */
        private final String f3187keyType;

        /* renamed from: status */
        private final KeyStatus f3188status;

        /* renamed from: equals */
        public boolean m3540equals(Object obj) {
            if (!(obj instanceof C0488Entry)) {
                return false;
            }
            C0488Entry c0488Entry = (C0488Entry) obj;
            return this.f3188status == c0488Entry.f3188status && this.f3186keyId == c0488Entry.f3186keyId && this.f3187keyType.equals(c0488Entry.f3187keyType) && this.keyPrefix.equals(c0488Entry.keyPrefix);
        }

        public int getKeyId() {
            return this.f3186keyId;
        }

        public String getKeyPrefix() {
            return this.keyPrefix;
        }

        public String getKeyType() {
            return this.f3187keyType;
        }

        public KeyStatus getStatus() {
            return this.f3188status;
        }

        public int hashCode() {
            return Objects.hash(this.f3188status, Integer.valueOf(this.f3186keyId), this.f3187keyType, this.keyPrefix);
        }

        public String toString() {
            return String.format("(status=%s, keyId=%s, keyType='%s', keyPrefix='%s')", this.f3188status, Integer.valueOf(this.f3186keyId), this.f3187keyType, this.keyPrefix);
        }

        private C0488Entry(KeyStatus keyStatus, int i, String str, String str2) {
            this.f3188status = keyStatus;
            this.f3186keyId = i;
            this.f3187keyType = str;
            this.keyPrefix = str2;
        }
    }

    public static C0487Builder newBuilder() {
        return new C0487Builder();
    }

    /* renamed from: equals */
    public boolean m3538equals(Object obj) {
        if (!(obj instanceof MonitoringKeysetInfo)) {
            return false;
        }
        MonitoringKeysetInfo monitoringKeysetInfo = (MonitoringKeysetInfo) obj;
        return this.annotations.m3533equals(monitoringKeysetInfo.annotations) && this.f3185entries.equals(monitoringKeysetInfo.f3185entries) && Objects.equals(this.primaryKeyId, monitoringKeysetInfo.primaryKeyId);
    }

    public MonitoringAnnotations getAnnotations() {
        return this.annotations;
    }

    public List<C0488Entry> getEntries() {
        return this.f3185entries;
    }

    @Nullable
    public Integer getPrimaryKeyId() {
        return this.primaryKeyId;
    }

    public int hashCode() {
        return Objects.hash(this.annotations, this.f3185entries);
    }

    public String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", this.annotations, this.f3185entries, this.primaryKeyId);
    }

    private MonitoringKeysetInfo(MonitoringAnnotations monitoringAnnotations, List<C0488Entry> list, Integer num) {
        this.annotations = monitoringAnnotations;
        this.f3185entries = list;
        this.primaryKeyId = num;
    }
}
