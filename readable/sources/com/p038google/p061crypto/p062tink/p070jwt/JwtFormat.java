package com.p038google.p061crypto.p062tink.p070jwt;

import com.p038google.p061crypto.p062tink.internal.C0431Util;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;
import com.p038google.p061crypto.p062tink.p075subtle.C0852Base64;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Optional;
import p131o.C4385q0;

/* loaded from: classes.dex */
final class JwtFormat {

    /* renamed from: com.google.crypto.tink.jwt.JwtFormat$Parts */
    public static class C0437Parts {

        /* renamed from: header */
        String f3125header;

        /* renamed from: payload */
        String f3126payload;
        byte[] signatureOrMac;
        String unsignedCompact;

        public C0437Parts(String str, byte[] bArr, String str2, String str3) {
            this.unsignedCompact = str;
            this.signatureOrMac = bArr;
            this.f3125header = str2;
            this.f3126payload = str3;
        }
    }

    private JwtFormat() {
    }

    public static String createHeader(String str, Optional<String> optional, Optional<String> optional2) throws InvalidAlgorithmParameterException {
        validateAlgorithm(str);
        C4385q0 c4385q0 = new C4385q0();
        if (optional2.isPresent()) {
            c4385q0.m13153Pq("kid", optional2.get());
        }
        c4385q0.m13153Pq("alg", str);
        if (optional.isPresent()) {
            c4385q0.m13153Pq("typ", optional.get());
        }
        return C0852Base64.urlSafeEncode(c4385q0.toString().getBytes(C0431Util.f3121UTF_8));
    }

    public static String createSignedCompact(String str, byte[] bArr) {
        return str + "." + encodeSignature(bArr);
    }

    public static String createUnsignedCompact(String str, Optional<String> optional, C0454RawJwt c0454RawJwt) {
        String jsonPayload = c0454RawJwt.getJsonPayload();
        return createHeader(str, c0454RawJwt.hasTypeHeader() ? Optional.of(c0454RawJwt.getTypeHeader()) : Optional.empty(), optional) + "." + encodePayload(jsonPayload);
    }

    public static String decodeHeader(String str) throws JwtInvalidException, CharacterCodingException {
        byte[] bArrStrictUrlSafeDecode = strictUrlSafeDecode(str);
        validateUtf8(bArrStrictUrlSafeDecode);
        return new String(bArrStrictUrlSafeDecode, C0431Util.f3121UTF_8);
    }

    public static String decodePayload(String str) throws JwtInvalidException, CharacterCodingException {
        byte[] bArrStrictUrlSafeDecode = strictUrlSafeDecode(str);
        validateUtf8(bArrStrictUrlSafeDecode);
        return new String(bArrStrictUrlSafeDecode, C0431Util.f3121UTF_8);
    }

    public static byte[] decodeSignature(String str) {
        return strictUrlSafeDecode(str);
    }

    public static String encodePayload(String str) {
        return C0852Base64.urlSafeEncode(str.getBytes(C0431Util.f3121UTF_8));
    }

    public static String encodeSignature(byte[] bArr) {
        return C0852Base64.urlSafeEncode(bArr);
    }

    public static Optional<Integer> getKeyId(String str) {
        byte[] bArrUrlSafeDecode = C0852Base64.urlSafeDecode(str);
        return bArrUrlSafeDecode.length != 4 ? Optional.empty() : Optional.of(Integer.valueOf(ByteBuffer.wrap(bArrUrlSafeDecode).getInt()));
    }

    /* renamed from: getKid */
    public static Optional<String> m3506getKid(int i, OutputPrefixType outputPrefixType) throws JwtInvalidException {
        if (outputPrefixType == OutputPrefixType.RAW) {
            return Optional.empty();
        }
        if (outputPrefixType == OutputPrefixType.TINK) {
            return Optional.of(C0852Base64.urlSafeEncode(ByteBuffer.allocate(4).putInt(i).array()));
        }
        throw new JwtInvalidException("unsupported output prefix type");
    }

    private static String getStringHeader(C4385q0 c4385q0, String str) throws JwtInvalidException {
        if (!c4385q0.m13151HGpJ(str)) {
            throw new JwtInvalidException("header " + str + " does not exist");
        }
        if (c4385q0.m13154Ucbh(str).m12833qGY() && c4385q0.m13154Ucbh(str).m12834qdMbNW().m13436Ucbh()) {
            return c4385q0.m13154Ucbh(str).mo12267VA();
        }
        throw new JwtInvalidException("header " + str + " is not a string");
    }

    public static Optional<String> getTypeHeader(C4385q0 c4385q0) {
        return c4385q0.m13151HGpJ("typ") ? Optional.of(getStringHeader(c4385q0, "typ")) : Optional.empty();
    }

    public static boolean isValidUrlsafeBase64Char(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || ((c >= '0' && c <= '9') || c == '-' || c == '_');
    }

    public static C0437Parts splitSignedCompact(String str) throws JwtInvalidException {
        validateASCII(str);
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
        }
        String strSubstring = str.substring(0, iLastIndexOf);
        byte[] bArrDecodeSignature = decodeSignature(str.substring(iLastIndexOf + 1));
        int iIndexOf = strSubstring.indexOf(46);
        if (iIndexOf < 0) {
            throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
        }
        String strSubstring2 = strSubstring.substring(0, iIndexOf);
        String strSubstring3 = strSubstring.substring(iIndexOf + 1);
        if (strSubstring3.indexOf(46) <= 0) {
            return new C0437Parts(strSubstring, bArrDecodeSignature, decodeHeader(strSubstring2), decodePayload(strSubstring3));
        }
        throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
    }

    public static byte[] strictUrlSafeDecode(String str) throws JwtInvalidException {
        for (int i = 0; i < str.length(); i++) {
            if (!isValidUrlsafeBase64Char(str.charAt(i))) {
                throw new JwtInvalidException("invalid encoding");
            }
        }
        try {
            return C0852Base64.urlSafeDecode(str);
        } catch (IllegalArgumentException e) {
            throw new JwtInvalidException("invalid encoding: " + e);
        }
    }

    public static void validateASCII(String str) throws JwtInvalidException {
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) & 128) > 0) {
                throw new JwtInvalidException("Non ascii character");
            }
        }
    }

    private static void validateAlgorithm(String str) throws InvalidAlgorithmParameterException {
        str.hashCode();
        switch (str) {
            case "ES256":
            case "ES384":
            case "ES512":
            case "HS256":
            case "HS384":
            case "HS512":
            case "PS256":
            case "PS384":
            case "PS512":
            case "RS256":
            case "RS384":
            case "RS512":
                return;
            default:
                throw new InvalidAlgorithmParameterException("invalid algorithm: " + str);
        }
    }

    public static void validateHeader(String str, Optional<String> optional, Optional<String> optional2, C4385q0 c4385q0) throws JwtInvalidException, InvalidAlgorithmParameterException {
        validateAlgorithm(str);
        String stringHeader = getStringHeader(c4385q0, "alg");
        if (!stringHeader.equals(str)) {
            throw new InvalidAlgorithmParameterException(String.format("invalid algorithm; expected %s, got %s", str, stringHeader));
        }
        if (c4385q0.m13151HGpJ("crit")) {
            throw new JwtInvalidException("all tokens with crit headers are rejected");
        }
        if (optional.isPresent() && optional2.isPresent()) {
            throw new JwtInvalidException("custom_kid can only be set for RAW keys.");
        }
        boolean zM13151HGpJ = c4385q0.m13151HGpJ("kid");
        if (optional.isPresent()) {
            if (!zM13151HGpJ) {
                throw new JwtInvalidException("missing kid in header");
            }
            validateKidInHeader(optional.get(), c4385q0);
        }
        if (optional2.isPresent() && zM13151HGpJ) {
            validateKidInHeader(optional2.get(), c4385q0);
        }
    }

    private static void validateKidInHeader(String str, C4385q0 c4385q0) throws JwtInvalidException {
        if (!getStringHeader(c4385q0, "kid").equals(str)) {
            throw new JwtInvalidException("invalid kid in header");
        }
    }

    public static void validateUtf8(byte[] bArr) throws JwtInvalidException, CharacterCodingException {
        try {
            C0431Util.f3121UTF_8.newDecoder().decode(ByteBuffer.wrap(bArr));
        } catch (CharacterCodingException e) {
            throw new JwtInvalidException(e.getMessage());
        }
    }
}
