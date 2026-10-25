package com.p038google.p061crypto.p062tink.monitoring;

import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@InterfaceC0389Alpha
/* loaded from: classes.dex */
public final class MonitoringAnnotations {

    /* renamed from: EMPTY */
    public static final MonitoringAnnotations f3183EMPTY = newBuilder().m3537build();

    /* renamed from: entries */
    private final Map<String, String> f3184entries;

    /* renamed from: com.google.crypto.tink.monitoring.MonitoringAnnotations$Builder */
    public static final class C0484Builder {
        private HashMap<String, String> builderEntries = new HashMap<>();

        /* renamed from: add */
        public C0484Builder m3535add(String str, String str2) {
            HashMap<String, String> map = this.builderEntries;
            if (map == null) {
                throw new IllegalStateException("add cannot be called after build()");
            }
            map.put(str, str2);
            return this;
        }

        /* renamed from: addAll */
        public C0484Builder m3536addAll(Map<String, String> map) {
            HashMap<String, String> map2 = this.builderEntries;
            if (map2 == null) {
                throw new IllegalStateException("addAll cannot be called after build()");
            }
            map2.putAll(map);
            return this;
        }

        /* renamed from: build */
        public MonitoringAnnotations m3537build() {
            if (this.builderEntries == null) {
                throw new IllegalStateException("cannot call build() twice");
            }
            MonitoringAnnotations monitoringAnnotations = new MonitoringAnnotations(Collections.unmodifiableMap(this.builderEntries));
            this.builderEntries = null;
            return monitoringAnnotations;
        }
    }

    public static C0484Builder newBuilder() {
        return new C0484Builder();
    }

    /* renamed from: equals */
    public boolean m3533equals(Object obj) {
        if (obj instanceof MonitoringAnnotations) {
            return this.f3184entries.equals(((MonitoringAnnotations) obj).f3184entries);
        }
        return false;
    }

    public int hashCode() {
        return this.f3184entries.hashCode();
    }

    /* renamed from: toMap */
    public Map<String, String> m3534toMap() {
        return this.f3184entries;
    }

    public String toString() {
        return this.f3184entries.toString();
    }

    private MonitoringAnnotations(Map<String, String> map) {
        this.f3184entries = map;
    }
}
