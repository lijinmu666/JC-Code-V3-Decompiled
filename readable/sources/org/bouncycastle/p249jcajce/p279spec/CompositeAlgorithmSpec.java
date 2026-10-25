package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class CompositeAlgorithmSpec implements AlgorithmParameterSpec {
    private final List<String> algorithmNames;
    private final List<AlgorithmParameterSpec> parameterSpecs;

    /* renamed from: org.bouncycastle.jcajce.spec.CompositeAlgorithmSpec$Builder */
    public static class C5796Builder {
        private List<String> algorithmNames = new ArrayList();
        private List<AlgorithmParameterSpec> parameterSpecs = new ArrayList();

        /* renamed from: add */
        public C5796Builder m16182add(String str) {
            return m16183add(str, null);
        }

        /* renamed from: build */
        public CompositeAlgorithmSpec m16184build() {
            if (this.algorithmNames.isEmpty()) {
                throw new IllegalStateException("cannot call build with no algorithm names added");
            }
            return new CompositeAlgorithmSpec(this);
        }

        /* renamed from: add */
        public C5796Builder m16183add(String str, AlgorithmParameterSpec algorithmParameterSpec) {
            if (this.algorithmNames.contains(str)) {
                throw new IllegalStateException("cannot build with the same algorithm name added");
            }
            this.algorithmNames.add(str);
            this.parameterSpecs.add(algorithmParameterSpec);
            return this;
        }
    }

    public CompositeAlgorithmSpec(C5796Builder c5796Builder) {
        this.algorithmNames = Collections.unmodifiableList(new ArrayList(c5796Builder.algorithmNames));
        this.parameterSpecs = Collections.unmodifiableList(new ArrayList(c5796Builder.parameterSpecs));
    }

    public List<String> getAlgorithmNames() {
        return this.algorithmNames;
    }

    public List<AlgorithmParameterSpec> getParameterSpecs() {
        return this.parameterSpecs;
    }
}
