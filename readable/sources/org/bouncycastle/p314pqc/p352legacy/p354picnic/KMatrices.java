package org.bouncycastle.p314pqc.p352legacy.p354picnic;

/* loaded from: classes2.dex */
class KMatrices {

    /* renamed from: columns */
    private int f23963columns;

    /* renamed from: data */
    private int[] f23964data;
    private int nmatrices;

    /* renamed from: rows */
    private int f23965rows;

    public KMatrices(int i, int i2, int i3, int[] iArr) {
        this.nmatrices = i;
        this.f23965rows = i2;
        this.f23963columns = i3;
        this.f23964data = iArr;
    }

    public int getColumns() {
        return this.f23963columns;
    }

    /* renamed from: getData */
    public int[] m18081getData() {
        return this.f23964data;
    }

    public int getNmatrices() {
        return this.nmatrices;
    }

    /* renamed from: getRows */
    public int m18082getRows() {
        return this.f23965rows;
    }

    /* renamed from: getSize */
    public int m18083getSize() {
        return this.f23965rows * this.f23963columns;
    }
}
