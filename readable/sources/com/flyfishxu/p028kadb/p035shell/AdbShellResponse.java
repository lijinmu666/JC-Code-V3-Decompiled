package com.flyfishxu.p028kadb.p035shell;

import com.flyfishxu.p028kadb.p035shell.AdbShellResponse;
import org.conscrypt.BuildConfig;
import p094kotlin.C1120LazyKt;
import p094kotlin.InterfaceC1119Lazy;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u0012\u001a\u00020\u0003H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\n¨\u0006\u0013"}, m4988d2 = {"Lcom/flyfishxu/kadb/shell/AdbShellResponse;", BuildConfig.f24315FLAVOR, "output", BuildConfig.f24315FLAVOR, "errorOutput", "exitCode", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getOutput", "()Ljava/lang/String;", "getErrorOutput", "getExitCode", "()I", "allOutput", "getAllOutput", "allOutput$delegate", "Lkotlin/Lazy;", "toString", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AdbShellResponse {

    /* renamed from: allOutput$delegate, reason: from kotlin metadata */
    private final InterfaceC1119Lazy allOutput;
    private final String errorOutput;
    private final int exitCode;
    private final String output;

    public AdbShellResponse(String output, String errorOutput, int i) {
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(errorOutput, "errorOutput");
        this.output = output;
        this.errorOutput = errorOutput;
        this.exitCode = i;
        this.allOutput = C1120LazyKt.m4981lazy(new Function0() { // from class: o.CqaNbM
            @Override // p094kotlin.p105jvm.functions.Function0
            /* renamed from: invoke */
            public final Object mo4323invoke() {
                return AdbShellResponse.allOutput_delegate$lambda$0(this.f7748mjFkc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String allOutput_delegate$lambda$0(AdbShellResponse adbShellResponse) {
        return adbShellResponse.output + adbShellResponse.errorOutput;
    }

    public final String getAllOutput() {
        return (String) this.allOutput.getValue();
    }

    public final String getErrorOutput() {
        return this.errorOutput;
    }

    public final int getExitCode() {
        return this.exitCode;
    }

    public final String getOutput() {
        return this.output;
    }

    public String toString() {
        return "Shell response (" + this.exitCode + "):\n" + getAllOutput();
    }
}
