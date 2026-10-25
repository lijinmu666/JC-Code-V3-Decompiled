package p094kotlin.contracts;

import org.conscrypt.BuildConfig;
import p094kotlin.IgnorableReturnValue;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.ContractsDsl;

@SinceKotlin(m5061version = "1.3")
@ContractsDsl
@Metadata(m4987d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§\u0084\bb\u0002\b\u0006b\u0002\b\u0007b\u0002\b\bÊ\u0001\u0002\b\u0006Ê\u0001\u0002\b\u0007Ê\u0001\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¨\u0006\t"}, m4988d2 = {"Lkotlin/contracts/SimpleEffect;", "Lkotlin/contracts/Effect;", "implies", "Lkotlin/contracts/ConditionalEffect;", "booleanExpression", BuildConfig.f24315FLAVOR, "Lkotlin/internal/ContractsDsl;", "Lkotlin/contracts/ExperimentalContracts;", "Lkotlin/IgnorableReturnValue;", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.3"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@ExperimentalContracts
/* loaded from: classes.dex */
public interface SimpleEffect extends InterfaceC1192Effect {
    @ContractsDsl
    @ExperimentalContracts
    @IgnorableReturnValue
    /* renamed from: implies */
    ConditionalEffect m6096implies(boolean booleanExpression);
}
