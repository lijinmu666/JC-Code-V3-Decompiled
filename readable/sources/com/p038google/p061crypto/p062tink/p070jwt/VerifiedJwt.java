package com.p038google.p061crypto.p062tink.p070jwt;

import java.time.Instant;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class VerifiedJwt {

    /* renamed from: rawJwt */
    private final C0454RawJwt f3143rawJwt;

    public VerifiedJwt(C0454RawJwt c0454RawJwt) {
        this.f3143rawJwt = c0454RawJwt;
    }

    public Set<String> customClaimNames() {
        return this.f3143rawJwt.customClaimNames();
    }

    public List<String> getAudiences() {
        return this.f3143rawJwt.getAudiences();
    }

    public Boolean getBooleanClaim(String str) {
        return this.f3143rawJwt.getBooleanClaim(str);
    }

    public Instant getExpiration() {
        return this.f3143rawJwt.getExpiration();
    }

    public Instant getIssuedAt() {
        return this.f3143rawJwt.getIssuedAt();
    }

    public String getIssuer() {
        return this.f3143rawJwt.getIssuer();
    }

    public String getJsonArrayClaim(String str) {
        return this.f3143rawJwt.getJsonArrayClaim(str);
    }

    public String getJsonObjectClaim(String str) {
        return this.f3143rawJwt.getJsonObjectClaim(str);
    }

    public String getJwtId() {
        return this.f3143rawJwt.getJwtId();
    }

    public Instant getNotBefore() {
        return this.f3143rawJwt.getNotBefore();
    }

    public Double getNumberClaim(String str) {
        return this.f3143rawJwt.getNumberClaim(str);
    }

    public String getStringClaim(String str) {
        return this.f3143rawJwt.getStringClaim(str);
    }

    public String getSubject() {
        return this.f3143rawJwt.getSubject();
    }

    public String getTypeHeader() {
        return this.f3143rawJwt.getTypeHeader();
    }

    public boolean hasAudiences() {
        return this.f3143rawJwt.hasAudiences();
    }

    public boolean hasBooleanClaim(String str) {
        return this.f3143rawJwt.hasBooleanClaim(str);
    }

    public boolean hasExpiration() {
        return this.f3143rawJwt.hasExpiration();
    }

    public boolean hasIssuedAt() {
        return this.f3143rawJwt.hasIssuedAt();
    }

    public boolean hasIssuer() {
        return this.f3143rawJwt.hasIssuer();
    }

    public boolean hasJsonArrayClaim(String str) {
        return this.f3143rawJwt.hasJsonArrayClaim(str);
    }

    public boolean hasJsonObjectClaim(String str) {
        return this.f3143rawJwt.hasJsonObjectClaim(str);
    }

    public boolean hasJwtId() {
        return this.f3143rawJwt.hasJwtId();
    }

    public boolean hasNotBefore() {
        return this.f3143rawJwt.hasNotBefore();
    }

    public boolean hasNumberClaim(String str) {
        return this.f3143rawJwt.hasNumberClaim(str);
    }

    public boolean hasStringClaim(String str) {
        return this.f3143rawJwt.hasStringClaim(str);
    }

    public boolean hasSubject() {
        return this.f3143rawJwt.hasSubject();
    }

    public boolean hasTypeHeader() {
        return this.f3143rawJwt.hasTypeHeader();
    }

    public boolean isNullClaim(String str) {
        return this.f3143rawJwt.isNullClaim(str);
    }

    public String toString() {
        return "verified{" + this.f3143rawJwt + "}";
    }
}
