package com.p038google.p061crypto.p062tink.p070jwt;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Optional;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class JwtValidator {
    private static final Duration MAX_CLOCK_SKEW = Duration.ofMinutes(10);
    private final boolean allowMissingExpiration;

    /* renamed from: clock */
    private final Clock f3139clock;
    private final Duration clockSkew;
    private final boolean expectIssuedInThePast;
    private final Optional<String> expectedAudience;
    private final Optional<String> expectedIssuer;
    private final Optional<String> expectedTypeHeader;
    private final boolean ignoreAudiences;
    private final boolean ignoreIssuer;
    private final boolean ignoreTypeHeader;

    /* renamed from: com.google.crypto.tink.jwt.JwtValidator$Builder */
    public static final class C0453Builder {
        private boolean allowMissingExpiration;

        /* renamed from: clock */
        private Clock f3140clock;
        private Duration clockSkew;
        private boolean expectIssuedInThePast;
        private Optional<String> expectedAudience;
        private Optional<String> expectedIssuer;
        private Optional<String> expectedTypeHeader;
        private boolean ignoreAudiences;
        private boolean ignoreIssuer;
        private boolean ignoreTypeHeader;

        public C0453Builder allowMissingExpiration() {
            this.allowMissingExpiration = true;
            return this;
        }

        /* renamed from: build */
        public JwtValidator m3507build() {
            if (this.ignoreTypeHeader && this.expectedTypeHeader.isPresent()) {
                throw new IllegalArgumentException("ignoreTypeHeader() and expectedTypeHeader() cannot be used together.");
            }
            if (this.ignoreIssuer && this.expectedIssuer.isPresent()) {
                throw new IllegalArgumentException("ignoreIssuer() and expectedIssuer() cannot be used together.");
            }
            if (this.ignoreAudiences && this.expectedAudience.isPresent()) {
                throw new IllegalArgumentException("ignoreAudiences() and expectedAudience() cannot be used together.");
            }
            return new JwtValidator(this);
        }

        public C0453Builder expectAudience(String str) {
            if (str == null) {
                throw new NullPointerException("audience cannot be null");
            }
            this.expectedAudience = Optional.of(str);
            return this;
        }

        public C0453Builder expectIssuedInThePast() {
            this.expectIssuedInThePast = true;
            return this;
        }

        public C0453Builder expectIssuer(String str) {
            if (str == null) {
                throw new NullPointerException("issuer cannot be null");
            }
            this.expectedIssuer = Optional.of(str);
            return this;
        }

        public C0453Builder expectTypeHeader(String str) {
            if (str == null) {
                throw new NullPointerException("typ header cannot be null");
            }
            this.expectedTypeHeader = Optional.of(str);
            return this;
        }

        public C0453Builder ignoreAudiences() {
            this.ignoreAudiences = true;
            return this;
        }

        public C0453Builder ignoreIssuer() {
            this.ignoreIssuer = true;
            return this;
        }

        public C0453Builder ignoreTypeHeader() {
            this.ignoreTypeHeader = true;
            return this;
        }

        public C0453Builder setClock(Clock clock) {
            if (clock == null) {
                throw new NullPointerException("clock cannot be null");
            }
            this.f3140clock = clock;
            return this;
        }

        public C0453Builder setClockSkew(Duration duration) {
            if (duration.compareTo(JwtValidator.MAX_CLOCK_SKEW) > 0) {
                throw new IllegalArgumentException("Clock skew too large, max is 10 minutes");
            }
            this.clockSkew = duration;
            return this;
        }

        private C0453Builder() {
            this.f3140clock = Clock.systemUTC();
            this.clockSkew = Duration.ZERO;
            this.expectedTypeHeader = Optional.empty();
            this.ignoreTypeHeader = false;
            this.expectedIssuer = Optional.empty();
            this.ignoreIssuer = false;
            this.expectedAudience = Optional.empty();
            this.ignoreAudiences = false;
            this.allowMissingExpiration = false;
            this.expectIssuedInThePast = false;
        }
    }

    public static C0453Builder newBuilder() {
        return new C0453Builder();
    }

    private void validateAudiences(C0454RawJwt c0454RawJwt) throws JwtInvalidException {
        if (this.expectedAudience.isPresent()) {
            if (!c0454RawJwt.hasAudiences() || !c0454RawJwt.getAudiences().contains(this.expectedAudience.get())) {
                throw new JwtInvalidException(String.format("invalid JWT; missing expected audience %s.", this.expectedAudience.get()));
            }
        } else if (c0454RawJwt.hasAudiences() && !this.ignoreAudiences) {
            throw new JwtInvalidException("invalid JWT; token has audience set, but validator not.");
        }
    }

    private void validateIssuer(C0454RawJwt c0454RawJwt) throws JwtInvalidException {
        if (!this.expectedIssuer.isPresent()) {
            if (c0454RawJwt.hasIssuer() && !this.ignoreIssuer) {
                throw new JwtInvalidException("invalid JWT; token has issuer set, but validator not.");
            }
        } else {
            if (!c0454RawJwt.hasIssuer()) {
                throw new JwtInvalidException(String.format("invalid JWT; missing expected issuer %s.", this.expectedIssuer.get()));
            }
            if (!c0454RawJwt.getIssuer().equals(this.expectedIssuer.get())) {
                throw new JwtInvalidException(String.format("invalid JWT; expected issuer %s, but got %s", this.expectedIssuer.get(), c0454RawJwt.getIssuer()));
            }
        }
    }

    private void validateTimestampClaims(C0454RawJwt c0454RawJwt) throws JwtInvalidException {
        Instant instant = this.f3139clock.instant();
        if (!c0454RawJwt.hasExpiration() && !this.allowMissingExpiration) {
            throw new JwtInvalidException("token does not have an expiration set");
        }
        if (c0454RawJwt.hasExpiration() && !c0454RawJwt.getExpiration().isAfter(instant.minus((TemporalAmount) this.clockSkew))) {
            throw new JwtInvalidException("token has expired since " + c0454RawJwt.getExpiration());
        }
        if (c0454RawJwt.hasNotBefore() && c0454RawJwt.getNotBefore().isAfter(instant.plus((TemporalAmount) this.clockSkew))) {
            throw new JwtInvalidException("token cannot be used before " + c0454RawJwt.getNotBefore());
        }
        if (this.expectIssuedInThePast) {
            if (!c0454RawJwt.hasIssuedAt()) {
                throw new JwtInvalidException("token does not have an iat claim");
            }
            if (c0454RawJwt.getIssuedAt().isAfter(instant.plus((TemporalAmount) this.clockSkew))) {
                throw new JwtInvalidException("token has a invalid iat claim in the future: " + c0454RawJwt.getIssuedAt());
            }
        }
    }

    private void validateTypeHeader(C0454RawJwt c0454RawJwt) throws JwtInvalidException {
        if (!this.expectedTypeHeader.isPresent()) {
            if (c0454RawJwt.hasTypeHeader() && !this.ignoreTypeHeader) {
                throw new JwtInvalidException("invalid JWT; token has type header set, but validator not.");
            }
        } else {
            if (!c0454RawJwt.hasTypeHeader()) {
                throw new JwtInvalidException(String.format("invalid JWT; missing expected type header %s.", this.expectedTypeHeader.get()));
            }
            if (!c0454RawJwt.getTypeHeader().equals(this.expectedTypeHeader.get())) {
                throw new JwtInvalidException(String.format("invalid JWT; expected type header %s, but got %s", this.expectedTypeHeader.get(), c0454RawJwt.getTypeHeader()));
            }
        }
    }

    public String toString() {
        ArrayList<String> arrayList = new ArrayList();
        if (this.expectedTypeHeader.isPresent()) {
            arrayList.add("expectedTypeHeader=" + this.expectedTypeHeader.get());
        }
        if (this.ignoreTypeHeader) {
            arrayList.add("ignoreTypeHeader");
        }
        if (this.expectedIssuer.isPresent()) {
            arrayList.add("expectedIssuer=" + this.expectedIssuer.get());
        }
        if (this.ignoreIssuer) {
            arrayList.add("ignoreIssuer");
        }
        if (this.expectedAudience.isPresent()) {
            arrayList.add("expectedAudience=" + this.expectedAudience.get());
        }
        if (this.ignoreAudiences) {
            arrayList.add("ignoreAudiences");
        }
        if (this.allowMissingExpiration) {
            arrayList.add("allowMissingExpiration");
        }
        if (this.expectIssuedInThePast) {
            arrayList.add("expectIssuedInThePast");
        }
        if (!this.clockSkew.isZero()) {
            arrayList.add("clockSkew=" + this.clockSkew);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("JwtValidator{");
        String str = BuildConfig.f24315FLAVOR;
        for (String str2 : arrayList) {
            sb.append(str);
            sb.append(str2);
            str = ",";
        }
        sb.append("}");
        return sb.toString();
    }

    public VerifiedJwt validate(C0454RawJwt c0454RawJwt) throws JwtInvalidException {
        validateTimestampClaims(c0454RawJwt);
        validateTypeHeader(c0454RawJwt);
        validateIssuer(c0454RawJwt);
        validateAudiences(c0454RawJwt);
        return new VerifiedJwt(c0454RawJwt);
    }

    private JwtValidator(C0453Builder c0453Builder) {
        this.expectedTypeHeader = c0453Builder.expectedTypeHeader;
        this.ignoreTypeHeader = c0453Builder.ignoreTypeHeader;
        this.expectedIssuer = c0453Builder.expectedIssuer;
        this.ignoreIssuer = c0453Builder.ignoreIssuer;
        this.expectedAudience = c0453Builder.expectedAudience;
        this.ignoreAudiences = c0453Builder.ignoreAudiences;
        this.allowMissingExpiration = c0453Builder.allowMissingExpiration;
        this.expectIssuedInThePast = c0453Builder.expectIssuedInThePast;
        this.f3139clock = c0453Builder.f3140clock;
        this.clockSkew = c0453Builder.clockSkew;
    }
}
