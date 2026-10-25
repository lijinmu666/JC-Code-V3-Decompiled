package org.bouncycastle.p358tsp;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p169tsp.MessageImprint;
import org.bouncycastle.p133asn1.p169tsp.TimeStampReq;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.Extensions;

/* loaded from: classes2.dex */
public class TimeStampRequest {
    private static Set EMPTY_SET = Collections.unmodifiableSet(new HashSet());
    private Extensions extensions;

    /* renamed from: req */
    private TimeStampReq f24156req;

    public TimeStampRequest(InputStream inputStream) {
        this(parseTimeStampReq(inputStream));
    }

    /* renamed from: convert */
    private Set m18204convert(Set set) {
        if (set == null) {
            return set;
        }
        HashSet hashSet = new HashSet(set.size());
        for (Object obj : set) {
            if (obj instanceof String) {
                hashSet.add(new ASN1ObjectIdentifier((String) obj));
            } else {
                hashSet.add(obj);
            }
        }
        return hashSet;
    }

    private static TimeStampReq parseTimeStampReq(InputStream inputStream) throws IOException {
        try {
            return TimeStampReq.getInstance(new ASN1InputStream(inputStream).readObject());
        } catch (ClassCastException e) {
            throw new IOException("malformed request: " + e);
        } catch (IllegalArgumentException e2) {
            throw new IOException("malformed request: " + e2);
        }
    }

    public boolean getCertReq() {
        if (this.f24156req.getCertReq() != null) {
            return this.f24156req.getCertReq().m14419isTrue();
        }
        return false;
    }

    public Set getCriticalExtensionOIDs() {
        return this.extensions == null ? EMPTY_SET : Collections.unmodifiableSet(new HashSet(Arrays.asList(this.extensions.getCriticalExtensionOIDs())));
    }

    public byte[] getEncoded() {
        return this.f24156req.getEncoded();
    }

    public Extension getExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Extensions extensions = this.extensions;
        if (extensions != null) {
            return extensions.getExtension(aSN1ObjectIdentifier);
        }
        return null;
    }

    public List getExtensionOIDs() {
        return C6230TSPUtil.getExtensionOIDs(this.extensions);
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public MessageImprint getMessageImprint() {
        return this.f24156req.getMessageImprint();
    }

    public AlgorithmIdentifier getMessageImprintAlgID() {
        return this.f24156req.getMessageImprint().getHashAlgorithm();
    }

    public ASN1ObjectIdentifier getMessageImprintAlgOID() {
        return this.f24156req.getMessageImprint().getHashAlgorithm().getAlgorithm();
    }

    public byte[] getMessageImprintDigest() {
        return this.f24156req.getMessageImprint().getHashedMessage();
    }

    public Set getNonCriticalExtensionOIDs() {
        return this.extensions == null ? EMPTY_SET : Collections.unmodifiableSet(new HashSet(Arrays.asList(this.extensions.getNonCriticalExtensionOIDs())));
    }

    public BigInteger getNonce() {
        if (this.f24156req.getNonce() != null) {
            return this.f24156req.getNonce().getValue();
        }
        return null;
    }

    public ASN1ObjectIdentifier getReqPolicy() {
        if (this.f24156req.getReqPolicy() != null) {
            return this.f24156req.getReqPolicy();
        }
        return null;
    }

    public int getVersion() {
        return this.f24156req.getVersion().intValueExact();
    }

    public boolean hasExtensions() {
        return this.extensions != null;
    }

    public TimeStampReq toASN1Structure() {
        return this.f24156req;
    }

    public void validate(Set set, Set set2, Set set3) throws TSPValidationException {
        Set setM18204convert = m18204convert(set);
        Set setM18204convert2 = m18204convert(set2);
        Set setM18204convert3 = m18204convert(set3);
        if (setM18204convert == null) {
            throw new TSPValidationException("no algorithms associated with request", 128);
        }
        if (!setM18204convert.contains(getMessageImprintAlgOID())) {
            throw new TSPValidationException("request contains unknown algorithm", 128);
        }
        if (setM18204convert2 != null && getReqPolicy() != null && !setM18204convert2.contains(getReqPolicy())) {
            throw new TSPValidationException("request contains unknown policy", 256);
        }
        if (getExtensions() != null && setM18204convert3 != null) {
            Enumeration enumerationM14687oids = getExtensions().m14687oids();
            while (enumerationM14687oids.hasMoreElements()) {
                if (!setM18204convert3.contains((ASN1ObjectIdentifier) enumerationM14687oids.nextElement())) {
                    throw new TSPValidationException("request contains unknown extension", 8388608);
                }
            }
        }
        if (C6230TSPUtil.getDigestLength(getMessageImprintAlgOID().m14433getId()) != getMessageImprint().getHashedMessageLength()) {
            throw new TSPValidationException("imprint digest the wrong length", 4);
        }
    }

    public TimeStampRequest(TimeStampReq timeStampReq) {
        this.f24156req = timeStampReq;
        this.extensions = timeStampReq.getExtensions();
    }

    private static TimeStampReq parseTimeStampReq(byte[] bArr) throws IOException {
        try {
            return TimeStampReq.getInstance(bArr);
        } catch (ClassCastException e) {
            throw new IOException("malformed request: " + e);
        } catch (IllegalArgumentException e2) {
            throw new IOException("malformed request: " + e2);
        }
    }

    public TimeStampRequest(byte[] bArr) {
        this(parseTimeStampReq(bArr));
    }
}
