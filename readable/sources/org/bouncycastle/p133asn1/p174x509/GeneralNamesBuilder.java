package org.bouncycastle.p133asn1.p174x509;

import java.util.Vector;

/* loaded from: classes2.dex */
public class GeneralNamesBuilder {

    /* renamed from: names */
    private Vector f18657names = new Vector();

    /* renamed from: addName */
    public GeneralNamesBuilder m14692addName(GeneralName generalName) {
        this.f18657names.addElement(generalName);
        return this;
    }

    public GeneralNamesBuilder addNames(GeneralNames generalNames) {
        GeneralName[] names = generalNames.getNames();
        for (int i = 0; i != names.length; i++) {
            this.f18657names.addElement(names[i]);
        }
        return this;
    }

    /* renamed from: build */
    public GeneralNames m14693build() {
        int size = this.f18657names.size();
        GeneralName[] generalNameArr = new GeneralName[size];
        for (int i = 0; i != size; i++) {
            generalNameArr[i] = (GeneralName) this.f18657names.elementAt(i);
        }
        return new GeneralNames(generalNameArr);
    }
}
