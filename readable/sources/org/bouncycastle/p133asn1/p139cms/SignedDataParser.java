package org.bouncycastle.p133asn1.p139cms;

import java.io.IOException;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1SequenceParser;
import org.bouncycastle.p133asn1.ASN1SetParser;
import org.bouncycastle.p133asn1.ASN1TaggedObjectParser;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;

/* loaded from: classes.dex */
public class SignedDataParser {
    private boolean _certsCalled;
    private boolean _crlsCalled;
    private Object _nextObject;

    /* renamed from: _seq */
    private ASN1SequenceParser f18227_seq;
    private ASN1Integer _version;

    private SignedDataParser(ASN1SequenceParser aSN1SequenceParser) {
        this.f18227_seq = aSN1SequenceParser;
        this._version = (ASN1Integer) aSN1SequenceParser.readObject();
    }

    public static SignedDataParser getInstance(Object obj) throws IOException {
        if (obj instanceof ASN1Sequence) {
            return new SignedDataParser(((ASN1Sequence) obj).m14449parser());
        }
        if (obj instanceof ASN1SequenceParser) {
            return new SignedDataParser((ASN1SequenceParser) obj);
        }
        throw new IOException("unknown object encountered: " + obj.getClass().getName());
    }

    public ASN1SetParser getCertificates() {
        this._certsCalled = true;
        ASN1Encodable object = this.f18227_seq.readObject();
        this._nextObject = object;
        if (object instanceof ASN1TaggedObjectParser) {
            ASN1TaggedObjectParser aSN1TaggedObjectParser = (ASN1TaggedObjectParser) object;
            if (aSN1TaggedObjectParser.hasContextTag(0)) {
                ASN1SetParser aSN1SetParser = (ASN1SetParser) aSN1TaggedObjectParser.parseBaseUniversal(false, 17);
                this._nextObject = null;
                return aSN1SetParser;
            }
        }
        return null;
    }

    /* renamed from: getCrls */
    public ASN1SetParser m14554getCrls() throws IOException {
        if (!this._certsCalled) {
            throw new IOException("getCerts() has not been called.");
        }
        this._crlsCalled = true;
        if (this._nextObject == null) {
            this._nextObject = this.f18227_seq.readObject();
        }
        Object obj = this._nextObject;
        if (obj instanceof ASN1TaggedObjectParser) {
            ASN1TaggedObjectParser aSN1TaggedObjectParser = (ASN1TaggedObjectParser) obj;
            if (aSN1TaggedObjectParser.hasContextTag(1)) {
                ASN1SetParser aSN1SetParser = (ASN1SetParser) aSN1TaggedObjectParser.parseBaseUniversal(false, 17);
                this._nextObject = null;
                return aSN1SetParser;
            }
        }
        return null;
    }

    public ASN1SetParser getDigestAlgorithms() {
        ASN1Encodable object = this.f18227_seq.readObject();
        return object instanceof AbstractC5093ASN1Set ? ((AbstractC5093ASN1Set) object).m14453parser() : (ASN1SetParser) object;
    }

    public ContentInfoParser getEncapContentInfo() {
        return new ContentInfoParser((ASN1SequenceParser) this.f18227_seq.readObject());
    }

    public ASN1SetParser getSignerInfos() throws IOException {
        if (!this._certsCalled || !this._crlsCalled) {
            throw new IOException("getCerts() and/or getCrls() has not been called.");
        }
        if (this._nextObject == null) {
            this._nextObject = this.f18227_seq.readObject();
        }
        return (ASN1SetParser) this._nextObject;
    }

    public ASN1Integer getVersion() {
        return this._version;
    }
}
