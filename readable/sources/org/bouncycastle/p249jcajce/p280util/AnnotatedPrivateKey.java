package org.bouncycastle.p249jcajce.p280util;

import java.security.PrivateKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class AnnotatedPrivateKey implements PrivateKey {

    /* renamed from: LABEL */
    public static final String f21953LABEL = "label";
    private final Map<String, Object> annotations;

    /* renamed from: key */
    private final PrivateKey f21954key;

    public AnnotatedPrivateKey(PrivateKey privateKey, String str) {
        this.f21954key = privateKey;
        this.annotations = Collections.singletonMap(f21953LABEL, str);
    }

    public AnnotatedPrivateKey addAnnotation(String str, Object obj) {
        HashMap map = new HashMap(this.annotations);
        map.put(str, obj);
        return new AnnotatedPrivateKey(this.f21954key, (Map<String, Object>) Collections.unmodifiableMap(map));
    }

    /* renamed from: equals */
    public boolean m16223equals(Object obj) {
        boolean z = obj instanceof AnnotatedPrivateKey;
        PrivateKey privateKey = this.f21954key;
        return z ? privateKey.equals(((AnnotatedPrivateKey) obj).f21954key) : privateKey.equals(obj);
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.f21954key.getAlgorithm();
    }

    public Object getAnnotation(String str) {
        return this.annotations.get(str);
    }

    public Map<String, Object> getAnnotations() {
        return this.annotations;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return this.f21954key.getEncoded();
    }

    @Override // java.security.Key
    public String getFormat() {
        return this.f21954key.getFormat();
    }

    /* renamed from: getKey */
    public PrivateKey m16224getKey() {
        return this.f21954key;
    }

    public int hashCode() {
        return this.f21954key.hashCode();
    }

    public AnnotatedPrivateKey removeAnnotation(String str) {
        HashMap map = new HashMap(this.annotations);
        map.remove(str);
        return new AnnotatedPrivateKey(this.f21954key, (Map<String, Object>) Collections.unmodifiableMap(map));
    }

    public String toString() {
        return (this.annotations.containsKey(f21953LABEL) ? this.annotations.get(f21953LABEL) : this.f21954key).toString();
    }

    public AnnotatedPrivateKey(PrivateKey privateKey, Map<String, Object> map) {
        this.f21954key = privateKey;
        this.annotations = map;
    }
}
