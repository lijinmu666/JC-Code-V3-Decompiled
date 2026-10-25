package com.indidevs.p086android.p087adbeesh.p090runtime;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0019"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/runtime/AdbShellResult;", BuildConfig.f24315FLAVOR, "exitCode", BuildConfig.f24315FLAVOR, "output", BuildConfig.f24315FLAVOR, "error", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getExitCode", "()I", "getOutput", "()Ljava/lang/String;", "getError", "isSuccess", BuildConfig.f24315FLAVOR, "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final /* data */ class AdbShellResult {
    private final String error;
    private final int exitCode;
    private final String output;

    public AdbShellResult(int i, String output, String str) {
        Intrinsics.checkNotNullParameter(output, "output");
        this.exitCode = i;
        this.output = output;
        this.error = str;
    }

    public static /* synthetic */ AdbShellResult copy$default(AdbShellResult adbShellResult, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = adbShellResult.exitCode;
        }
        if ((i2 & 2) != 0) {
            str = adbShellResult.output;
        }
        if ((i2 & 4) != 0) {
            str2 = adbShellResult.error;
        }
        return adbShellResult.m4369copy(i, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getExitCode() {
        return this.exitCode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getOutput() {
        return this.output;
    }

    /* renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: copy */
    public final AdbShellResult m4369copy(int exitCode, String output, String error) {
        Intrinsics.checkNotNullParameter(output, "output");
        return new AdbShellResult(exitCode, output, error);
    }

    /* renamed from: equals */
    public boolean m4370equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdbShellResult)) {
            return false;
        }
        AdbShellResult adbShellResult = (AdbShellResult) other;
        return this.exitCode == adbShellResult.exitCode && Intrinsics.areEqual(this.output, adbShellResult.output) && Intrinsics.areEqual(this.error, adbShellResult.error);
    }

    public final String getError() {
        return this.error;
    }

    public final int getExitCode() {
        return this.exitCode;
    }

    public final String getOutput() {
        return this.output;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.exitCode) * 31) + this.output.hashCode()) * 31;
        String str = this.error;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final boolean isSuccess() {
        return this.exitCode == 0;
    }

    public String toString() {
        return "AdbShellResult(exitCode=" + this.exitCode + ", output=" + this.output + ", error=" + this.error + ')';
    }

    public /* synthetic */ AdbShellResult(int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? null : str2);
    }
}
