package org.bouncycastle.p284math.p294field;

import java.math.BigInteger;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
class GenericPolynomialExtensionField implements PolynomialExtensionField {
    protected final Polynomial minimalPolynomial;
    protected final FiniteField subfield;

    public GenericPolynomialExtensionField(FiniteField finiteField, Polynomial polynomial) {
        this.subfield = finiteField;
        this.minimalPolynomial = polynomial;
    }

    /* renamed from: equals */
    public boolean m16875equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GenericPolynomialExtensionField)) {
            return false;
        }
        GenericPolynomialExtensionField genericPolynomialExtensionField = (GenericPolynomialExtensionField) obj;
        return this.subfield.equals(genericPolynomialExtensionField.subfield) && this.minimalPolynomial.equals(genericPolynomialExtensionField.minimalPolynomial);
    }

    @Override // org.bouncycastle.p284math.p294field.FiniteField
    public BigInteger getCharacteristic() {
        return this.subfield.getCharacteristic();
    }

    @Override // org.bouncycastle.p284math.p294field.ExtensionField
    public int getDegree() {
        return this.minimalPolynomial.getDegree();
    }

    @Override // org.bouncycastle.p284math.p294field.FiniteField
    public int getDimension() {
        return this.subfield.getDimension() * this.minimalPolynomial.getDegree();
    }

    @Override // org.bouncycastle.p284math.p294field.PolynomialExtensionField
    public Polynomial getMinimalPolynomial() {
        return this.minimalPolynomial;
    }

    @Override // org.bouncycastle.p284math.p294field.ExtensionField
    public FiniteField getSubfield() {
        return this.subfield;
    }

    public int hashCode() {
        return Integers.rotateLeft(this.minimalPolynomial.hashCode(), 16) ^ this.subfield.hashCode();
    }
}
