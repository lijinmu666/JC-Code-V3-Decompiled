package com.p038google.p061crypto.p062tink.p070jwt;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import p131o.AbstractC4187n0;
import p131o.C3858i0;
import p131o.C4318p0;
import p131o.C4385q0;
import p131o.C4454r0;
import p131o.C4520s0;

/* renamed from: com.google.crypto.tink.jwt.RawJwt */
/* loaded from: classes.dex */
public final class C0454RawJwt {
    private static final long MAX_TIMESTAMP_VALUE = 253402300799L;

    /* renamed from: payload */
    private final C4385q0 f3141payload;
    private final Optional<String> typeHeader;

    /* renamed from: com.google.crypto.tink.jwt.RawJwt$Builder */
    public static final class Builder {

        /* renamed from: payload */
        private final C4385q0 f3142payload;
        private Optional<String> typeHeader;
        private boolean withoutExpiration;

        private void setTimestampClaim(String str, Instant instant) {
            long epochSecond = instant.getEpochSecond();
            if (epochSecond <= C0454RawJwt.MAX_TIMESTAMP_VALUE && epochSecond >= 0) {
                this.f3142payload.m13158fehf(str, new C4520s0(Long.valueOf(epochSecond)));
                return;
            }
            throw new IllegalArgumentException("timestamp of claim " + str + " is out of range");
        }

        public Builder addAudience(String str) {
            C3858i0 c3858i0;
            if (!JsonUtil.isValidString(str)) {
                throw new IllegalArgumentException("invalid string");
            }
            if (this.f3142payload.m13151HGpJ("aud")) {
                AbstractC4187n0 abstractC4187n0M13154Ucbh = this.f3142payload.m13154Ucbh("aud");
                if (!abstractC4187n0M13154Ucbh.m12830MiMN()) {
                    throw new IllegalArgumentException("addAudience can't be used together with setAudience");
                }
                c3858i0 = abstractC4187n0M13154Ucbh.m12836xJ();
            } else {
                c3858i0 = new C3858i0();
            }
            c3858i0.m12271fehf(str);
            this.f3142payload.m13158fehf("aud", c3858i0);
            return this;
        }

        public Builder addBooleanClaim(String str, boolean z) {
            JwtNames.validate(str);
            this.f3142payload.m13158fehf(str, new C4520s0(Boolean.valueOf(z)));
            return this;
        }

        public Builder addJsonArrayClaim(String str, String str2) {
            JwtNames.validate(str);
            this.f3142payload.m13158fehf(str, JsonUtil.parseJsonArray(str2));
            return this;
        }

        public Builder addJsonObjectClaim(String str, String str2) {
            JwtNames.validate(str);
            this.f3142payload.m13158fehf(str, JsonUtil.parseJson(str2));
            return this;
        }

        public Builder addNullClaim(String str) {
            JwtNames.validate(str);
            this.f3142payload.m13158fehf(str, C4318p0.f15892mjFkc);
            return this;
        }

        public Builder addNumberClaim(String str, double d) {
            JwtNames.validate(str);
            this.f3142payload.m13158fehf(str, new C4520s0(Double.valueOf(d)));
            return this;
        }

        public Builder addStringClaim(String str, String str2) {
            if (!JsonUtil.isValidString(str2)) {
                throw new IllegalArgumentException();
            }
            JwtNames.validate(str);
            this.f3142payload.m13158fehf(str, new C4520s0(str2));
            return this;
        }

        /* renamed from: build */
        public C0454RawJwt m3508build() {
            return new C0454RawJwt(this);
        }

        public Builder setAudience(String str) {
            if (this.f3142payload.m13151HGpJ("aud") && this.f3142payload.m13154Ucbh("aud").m12830MiMN()) {
                throw new IllegalArgumentException("setAudience can't be used together with setAudiences or addAudience");
            }
            if (!JsonUtil.isValidString(str)) {
                throw new IllegalArgumentException("invalid string");
            }
            this.f3142payload.m13158fehf("aud", new C4520s0(str));
            return this;
        }

        public Builder setAudiences(List<String> list) {
            if (this.f3142payload.m13151HGpJ("aud") && !this.f3142payload.m13154Ucbh("aud").m12830MiMN()) {
                throw new IllegalArgumentException("setAudiences can't be used together with setAudience");
            }
            if (list.isEmpty()) {
                throw new IllegalArgumentException("audiences must not be empty");
            }
            C3858i0 c3858i0 = new C3858i0();
            for (String str : list) {
                if (!JsonUtil.isValidString(str)) {
                    throw new IllegalArgumentException("invalid string");
                }
                c3858i0.m12271fehf(str);
            }
            this.f3142payload.m13158fehf("aud", c3858i0);
            return this;
        }

        public Builder setExpiration(Instant instant) {
            setTimestampClaim("exp", instant);
            return this;
        }

        public Builder setIssuedAt(Instant instant) {
            setTimestampClaim("iat", instant);
            return this;
        }

        public Builder setIssuer(String str) {
            if (!JsonUtil.isValidString(str)) {
                throw new IllegalArgumentException();
            }
            this.f3142payload.m13158fehf("iss", new C4520s0(str));
            return this;
        }

        public Builder setJwtId(String str) {
            if (!JsonUtil.isValidString(str)) {
                throw new IllegalArgumentException();
            }
            this.f3142payload.m13158fehf("jti", new C4520s0(str));
            return this;
        }

        public Builder setNotBefore(Instant instant) {
            setTimestampClaim("nbf", instant);
            return this;
        }

        public Builder setSubject(String str) {
            if (!JsonUtil.isValidString(str)) {
                throw new IllegalArgumentException();
            }
            this.f3142payload.m13158fehf("sub", new C4520s0(str));
            return this;
        }

        public Builder setTypeHeader(String str) {
            this.typeHeader = Optional.of(str);
            return this;
        }

        public Builder withoutExpiration() {
            this.withoutExpiration = true;
            return this;
        }

        private Builder() {
            this.typeHeader = Optional.empty();
            this.withoutExpiration = false;
            this.f3142payload = new C4385q0();
        }
    }

    public static C0454RawJwt fromJsonPayload(Optional<String> optional, String str) {
        return new C0454RawJwt(optional, str);
    }

    private Instant getInstant(String str) throws JwtInvalidException {
        if (!this.f3141payload.m13151HGpJ(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (!this.f3141payload.m13154Ucbh(str).m12833qGY() || !this.f3141payload.m13154Ucbh(str).m12834qdMbNW().m13438eyqo()) {
            throw new JwtInvalidException("claim " + str + " is not a timestamp");
        }
        try {
            return Instant.ofEpochMilli((long) (this.f3141payload.m13154Ucbh(str).m12834qdMbNW().mo12265JHa() * 1000.0d));
        } catch (NumberFormatException e) {
            throw new JwtInvalidException("claim " + str + " is not a timestamp: " + e);
        }
    }

    private String getStringClaimInternal(String str) throws JwtInvalidException {
        if (!this.f3141payload.m13151HGpJ(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (this.f3141payload.m13154Ucbh(str).m12833qGY() && this.f3141payload.m13154Ucbh(str).m12834qdMbNW().m13436Ucbh()) {
            return this.f3141payload.m13154Ucbh(str).mo12267VA();
        }
        throw new JwtInvalidException("claim " + str + " is not a string");
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    private void validateAudienceClaim() throws JwtInvalidException {
        if (this.f3141payload.m13151HGpJ("aud")) {
            if (!(this.f3141payload.m13154Ucbh("aud").m12833qGY() && this.f3141payload.m13154Ucbh("aud").m12834qdMbNW().m13436Ucbh()) && getAudiences().size() < 1) {
                throw new JwtInvalidException("invalid JWT payload: claim aud is present but empty.");
            }
        }
    }

    private void validateStringClaim(String str) throws JwtInvalidException {
        if (this.f3141payload.m13151HGpJ(str)) {
            if (this.f3141payload.m13154Ucbh(str).m12833qGY() && this.f3141payload.m13154Ucbh(str).m12834qdMbNW().m13436Ucbh()) {
                return;
            }
            throw new JwtInvalidException("invalid JWT payload: claim " + str + " is not a string.");
        }
    }

    private void validateTimestampClaim(String str) throws JwtInvalidException {
        if (this.f3141payload.m13151HGpJ(str)) {
            if (!this.f3141payload.m13154Ucbh(str).m12833qGY() || !this.f3141payload.m13154Ucbh(str).m12834qdMbNW().m13438eyqo()) {
                throw new JwtInvalidException("invalid JWT payload: claim " + str + " is not a number.");
            }
            double dMo12265JHa = this.f3141payload.m13154Ucbh(str).m12834qdMbNW().mo12265JHa();
            if (dMo12265JHa > 2.53402300799E11d || dMo12265JHa < 0.0d) {
                throw new JwtInvalidException("invalid JWT payload: claim " + str + " has an invalid timestamp");
            }
        }
    }

    public Set<String> customClaimNames() {
        HashSet hashSet = new HashSet();
        for (String str : this.f3141payload.m13160vI()) {
            if (!JwtNames.isRegisteredName(str)) {
                hashSet.add(str);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public List<String> getAudiences() throws JwtInvalidException {
        if (!hasAudiences()) {
            throw new JwtInvalidException("claim aud does not exist");
        }
        AbstractC4187n0 abstractC4187n0M13154Ucbh = this.f3141payload.m13154Ucbh("aud");
        if (abstractC4187n0M13154Ucbh.m12833qGY()) {
            if (abstractC4187n0M13154Ucbh.m12834qdMbNW().m13436Ucbh()) {
                return Collections.unmodifiableList(Arrays.asList(abstractC4187n0M13154Ucbh.mo12267VA()));
            }
            throw new JwtInvalidException(String.format("invalid audience: got %s; want a string", abstractC4187n0M13154Ucbh));
        }
        if (!abstractC4187n0M13154Ucbh.m12830MiMN()) {
            throw new JwtInvalidException("claim aud is not a string or a JSON array");
        }
        C3858i0 c3858i0M12836xJ = abstractC4187n0M13154Ucbh.m12836xJ();
        ArrayList arrayList = new ArrayList(c3858i0M12836xJ.m12273size());
        for (int i = 0; i < c3858i0M12836xJ.m12273size(); i++) {
            if (!c3858i0M12836xJ.m12269diqgf(i).m12833qGY() || !c3858i0M12836xJ.m12269diqgf(i).m12834qdMbNW().m13436Ucbh()) {
                throw new JwtInvalidException(String.format("invalid audience: got %s; want a string", c3858i0M12836xJ.m12269diqgf(i)));
            }
            arrayList.add(c3858i0M12836xJ.m12269diqgf(i).mo12267VA());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Boolean getBooleanClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.f3141payload.m13151HGpJ(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (this.f3141payload.m13154Ucbh(str).m12833qGY() && this.f3141payload.m13154Ucbh(str).m12834qdMbNW().m13435Pq()) {
            return Boolean.valueOf(this.f3141payload.m13154Ucbh(str).mo12268ZfxDd());
        }
        throw new JwtInvalidException("claim " + str + " is not a boolean");
    }

    public Instant getExpiration() {
        return getInstant("exp");
    }

    public Instant getIssuedAt() {
        return getInstant("iat");
    }

    public String getIssuer() {
        return getStringClaimInternal("iss");
    }

    public String getJsonArrayClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.f3141payload.m13151HGpJ(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (this.f3141payload.m13154Ucbh(str).m12830MiMN()) {
            return this.f3141payload.m13154Ucbh(str).m12836xJ().toString();
        }
        throw new JwtInvalidException("claim " + str + " is not a JSON array");
    }

    public String getJsonObjectClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.f3141payload.m13151HGpJ(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (this.f3141payload.m13154Ucbh(str).m12835rkYL()) {
            return this.f3141payload.m13154Ucbh(str).m12832lgHUyS().toString();
        }
        throw new JwtInvalidException("claim " + str + " is not a JSON object");
    }

    public String getJsonPayload() {
        return this.f3141payload.toString();
    }

    public String getJwtId() {
        return getStringClaimInternal("jti");
    }

    public Instant getNotBefore() {
        return getInstant("nbf");
    }

    public Double getNumberClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.f3141payload.m13151HGpJ(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (this.f3141payload.m13154Ucbh(str).m12833qGY() && this.f3141payload.m13154Ucbh(str).m12834qdMbNW().m13438eyqo()) {
            return Double.valueOf(this.f3141payload.m13154Ucbh(str).mo12265JHa());
        }
        throw new JwtInvalidException("claim " + str + " is not a number");
    }

    public String getStringClaim(String str) {
        JwtNames.validate(str);
        return getStringClaimInternal(str);
    }

    public String getSubject() {
        return getStringClaimInternal("sub");
    }

    public String getTypeHeader() throws JwtInvalidException {
        if (this.typeHeader.isPresent()) {
            return this.typeHeader.get();
        }
        throw new JwtInvalidException("type header is not set");
    }

    public boolean hasAudiences() {
        return this.f3141payload.m13151HGpJ("aud");
    }

    public boolean hasBooleanClaim(String str) {
        JwtNames.validate(str);
        return this.f3141payload.m13151HGpJ(str) && this.f3141payload.m13154Ucbh(str).m12833qGY() && this.f3141payload.m13154Ucbh(str).m12834qdMbNW().m13435Pq();
    }

    public boolean hasExpiration() {
        return this.f3141payload.m13151HGpJ("exp");
    }

    public boolean hasIssuedAt() {
        return this.f3141payload.m13151HGpJ("iat");
    }

    public boolean hasIssuer() {
        return this.f3141payload.m13151HGpJ("iss");
    }

    public boolean hasJsonArrayClaim(String str) {
        JwtNames.validate(str);
        return this.f3141payload.m13151HGpJ(str) && this.f3141payload.m13154Ucbh(str).m12830MiMN();
    }

    public boolean hasJsonObjectClaim(String str) {
        JwtNames.validate(str);
        return this.f3141payload.m13151HGpJ(str) && this.f3141payload.m13154Ucbh(str).m12835rkYL();
    }

    public boolean hasJwtId() {
        return this.f3141payload.m13151HGpJ("jti");
    }

    public boolean hasNotBefore() {
        return this.f3141payload.m13151HGpJ("nbf");
    }

    public boolean hasNumberClaim(String str) {
        JwtNames.validate(str);
        return this.f3141payload.m13151HGpJ(str) && this.f3141payload.m13154Ucbh(str).m12833qGY() && this.f3141payload.m13154Ucbh(str).m12834qdMbNW().m13438eyqo();
    }

    public boolean hasStringClaim(String str) {
        JwtNames.validate(str);
        return this.f3141payload.m13151HGpJ(str) && this.f3141payload.m13154Ucbh(str).m12833qGY() && this.f3141payload.m13154Ucbh(str).m12834qdMbNW().m13436Ucbh();
    }

    public boolean hasSubject() {
        return this.f3141payload.m13151HGpJ("sub");
    }

    public boolean hasTypeHeader() {
        return this.typeHeader.isPresent();
    }

    public boolean isNullClaim(String str) {
        JwtNames.validate(str);
        try {
            return C4318p0.f15892mjFkc.m13057equals(this.f3141payload.m13154Ucbh(str));
        } catch (C4454r0 unused) {
            return false;
        }
    }

    public String toString() {
        C4385q0 c4385q0 = new C4385q0();
        if (this.typeHeader.isPresent()) {
            c4385q0.m13158fehf("typ", new C4520s0(this.typeHeader.get()));
        }
        return c4385q0 + "." + this.f3141payload;
    }

    private C0454RawJwt(Builder builder) {
        if (!builder.f3142payload.m13151HGpJ("exp") && !builder.withoutExpiration) {
            throw new IllegalArgumentException("neither setExpiration() nor withoutExpiration() was called");
        }
        if (builder.f3142payload.m13151HGpJ("exp") && builder.withoutExpiration) {
            throw new IllegalArgumentException("setExpiration() and withoutExpiration() must not be called together");
        }
        this.typeHeader = builder.typeHeader;
        this.f3141payload = builder.f3142payload.mo12272mjFkc();
    }

    private C0454RawJwt(Optional<String> optional, String str) throws JwtInvalidException {
        this.typeHeader = optional;
        this.f3141payload = JsonUtil.parseJson(str);
        validateStringClaim("iss");
        validateStringClaim("sub");
        validateStringClaim("jti");
        validateTimestampClaim("exp");
        validateTimestampClaim("nbf");
        validateTimestampClaim("iat");
        validateAudienceClaim();
    }
}
