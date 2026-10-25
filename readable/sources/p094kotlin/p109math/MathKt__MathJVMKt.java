package p094kotlin.p109math;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.InlineOnly;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m4987d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\b\b\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a,\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a \u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a \u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a,\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a(\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a$\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a$\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010 \u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a$\u0010!\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\"\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010#\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a,\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a,\u0010'\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010(\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b()b\u0002\b\u0006\u001a(\u0010*\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a(\u0010*\u001a\u00020\u0001*\u00020\u00012\u0006\u0010+\u001a\u00020,H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a(\u0010-\u001a\u00020\u0001*\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a(\u00106\u001a\u00020\u0001*\u00020\u00012\u0006\u0010#\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a(\u00106\u001a\u00020\u0001*\u00020\u00012\u0006\u0010#\u001a\u00020,H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010:\u001a\u00020\u0001*\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010;\u001a\u00020\u0001*\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a(\u0010<\u001a\u00020\u0001*\u00020\u00012\u0006\u0010=\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a\u001c\u0010>\u001a\u00020,*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a\u001c\u0010?\u001a\u00020@*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a$\u0010\u0000\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u0007\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\b\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\t\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\n\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u000b\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a,\u0010\f\u001a\u00020A2\u0006\u0010\r\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u000e\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u000f\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u0010\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u0011\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u0012\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u0013\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a,\u0010\u0014\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020A2\u0006\u0010\r\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u0015\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u0016\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u0017\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a(\u0010\u0018\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020A2\u0006\u0010\u0019\u001a\u00020AH\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a$\u0010\u001a\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u001b\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010\u001c\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a$\u0010\u001d\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u001e\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u001f\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010 \u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a$\u0010!\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\"\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010#\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a,\u0010$\u001a\u00020A2\u0006\u0010%\u001a\u00020A2\u0006\u0010&\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a,\u0010'\u001a\u00020A2\u0006\u0010%\u001a\u00020A2\u0006\u0010&\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010(\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b()b\u0002\b\u0006\u001a(\u0010*\u001a\u00020A*\u00020A2\u0006\u0010\u0002\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a(\u0010*\u001a\u00020A*\u00020A2\u0006\u0010+\u001a\u00020,H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a(\u0010-\u001a\u00020A*\u00020A2\u0006\u0010.\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a(\u00106\u001a\u00020A*\u00020A2\u0006\u0010#\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a(\u00106\u001a\u00020A*\u00020A2\u0006\u0010#\u001a\u00020,H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010:\u001a\u00020A*\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010;\u001a\u00020A*\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a(\u0010<\u001a\u00020A*\u00020A2\u0006\u0010=\u001a\u00020AH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a\u001c\u0010>\u001a\u00020,*\u00020AH\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a\u001c\u0010?\u001a\u00020@*\u00020AH\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a$\u0010\"\u001a\u00020,2\u0006\u0010+\u001a\u00020,H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a,\u0010$\u001a\u00020,2\u0006\u0010%\u001a\u00020,2\u0006\u0010&\u001a\u00020,H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a,\u0010'\u001a\u00020,2\u0006\u0010%\u001a\u00020,2\u0006\u0010&\u001a\u00020,H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\"\u001a\u00020@2\u0006\u0010+\u001a\u00020@H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a,\u0010$\u001a\u00020@2\u0006\u0010%\u001a\u00020@2\u0006\u0010&\u001a\u00020@H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a,\u0010'\u001a\u00020@2\u0006\u0010%\u001a\u00020@2\u0006\u0010&\u001a\u00020@H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\"2\u0010/\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0084\br\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005r\u0002\b\u0006¢\u0006\f\u0012\u0004\b0\u00101\u001a\u0004\b2\u00103\"2\u0010#\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0084\br\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005r\u0002\b\u0006¢\u0006\f\u0012\u0004\b4\u00101\u001a\u0004\b5\u00103\"2\u00107\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0084\br\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005r\u0002\b\u0006¢\u0006\f\u0012\u0004\b8\u00101\u001a\u0004\b9\u00103\"2\u0010/\u001a\u00020A*\u00020A8Æ\u0002X\u0087\u0084\br\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005r\u0002\b\u0006¢\u0006\f\u0012\u0004\b0\u0010B\u001a\u0004\b2\u0010C\"2\u0010#\u001a\u00020A*\u00020A8Æ\u0002X\u0087\u0084\br\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005r\u0002\b\u0006¢\u0006\f\u0012\u0004\b4\u0010B\u001a\u0004\b5\u0010C\"2\u00107\u001a\u00020A*\u00020A8Æ\u0002X\u0087\u0084\br\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005r\u0002\b\u0006¢\u0006\f\u0012\u0004\b8\u0010B\u001a\u0004\b9\u0010C\"2\u0010/\u001a\u00020,*\u00020,8Æ\u0002X\u0087\u0084\br\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005r\u0002\b\u0006¢\u0006\f\u0012\u0004\b0\u0010D\u001a\u0004\b2\u0010E\"-\u0010#\u001a\u00020,*\u00020,8FX\u0087\u0084\br\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005¢\u0006\f\u0012\u0004\b4\u0010D\u001a\u0004\b5\u0010E\"2\u0010/\u001a\u00020@*\u00020@8Æ\u0002X\u0087\u0084\br\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005r\u0002\b\u0006¢\u0006\f\u0012\u0004\b0\u0010F\u001a\u0004\b2\u0010G\"-\u0010#\u001a\u00020,*\u00020@8FX\u0087\u0084\br\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005¢\u0006\f\u0012\u0004\b4\u0010F\u001a\u0004\b5\u0010H¨\u0006I"}, m4988d2 = {"sin", BuildConfig.f24315FLAVOR, "x", "Lkotlin/SinceKotlin;", "version", "1.2", "Lkotlin/internal/InlineOnly;", "cos", "tan", "asin", "acos", "atan", "atan2", "y", "sinh", "cosh", "tanh", "asinh", "acosh", "atanh", "hypot", "sqrt", "exp", "expm1", "log", "base", "ln", "log10", "log2", "ln1p", "ceil", "floor", "truncate", "round", "abs", "sign", "min", "a", "b", "max", "cbrt", "1.8", "pow", "n", BuildConfig.f24315FLAVOR, "IEEErem", "divisor", "absoluteValue", "getAbsoluteValue$annotations", "(D)V", "getAbsoluteValue", "(D)D", "getSign$annotations", "getSign", "withSign", "ulp", "getUlp$annotations", "getUlp", "nextUp", "nextDown", "nextTowards", "to", "roundToInt", "roundToLong", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "(F)V", "(F)F", "(I)V", "(I)I", "(J)V", "(J)J", "(J)I", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/math/MathKt")
/* loaded from: classes.dex */
public class MathKt__MathJVMKt extends MathKt__MathHKt {
    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: IEEErem */
    private static final double m6353IEEErem(double d, double d2) {
        return Math.IEEEremainder(d, d2);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: abs */
    private static final double m6355abs(double d) {
        return Math.abs(d);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: acos */
    private static final double m6359acos(double d) {
        return Math.acos(d);
    }

    @SinceKotlin(m5061version = "1.2")
    /* renamed from: acosh */
    public static final double m6361acosh(double d) {
        if (d < 1.0d) {
            return Double.NaN;
        }
        if (d > Constants.upper_taylor_2_bound) {
            return Math.log(d) + Constants.LN2;
        }
        double d2 = 1;
        double d3 = d - d2;
        if (d3 >= Constants.taylor_n_bound) {
            return Math.log(d + Math.sqrt((d * d) - d2));
        }
        double dSqrt = Math.sqrt(d3);
        if (dSqrt >= Constants.taylor_2_bound) {
            dSqrt -= ((dSqrt * dSqrt) * dSqrt) / 12;
        }
        return dSqrt * Math.sqrt(2.0d);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: asin */
    private static final double m6363asin(double d) {
        return Math.asin(d);
    }

    @SinceKotlin(m5061version = "1.2")
    /* renamed from: asinh */
    public static final double m6365asinh(double d) {
        double d2 = Constants.taylor_n_bound;
        if (d < d2) {
            return d <= (-d2) ? -m6365asinh(-d) : Math.abs(d) >= Constants.taylor_2_bound ? d - (((d * d) * d) / 6) : d;
        }
        if (d <= Constants.upper_taylor_n_bound) {
            return Math.log(d + Math.sqrt((d * d) + 1));
        }
        if (d > Constants.upper_taylor_2_bound) {
            return Math.log(d) + Constants.LN2;
        }
        double d3 = d * 2;
        return Math.log(d3 + (1 / d3));
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: atan */
    private static final double m6367atan(double d) {
        return Math.atan(d);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: atan2 */
    private static final double m6369atan2(double d, double d2) {
        return Math.atan2(d, d2);
    }

    @SinceKotlin(m5061version = "1.2")
    /* renamed from: atanh */
    public static final double m6371atanh(double d) {
        if (Math.abs(d) < Constants.taylor_n_bound) {
            return Math.abs(d) > Constants.taylor_2_bound ? d + (((d * d) * d) / 3) : d;
        }
        double d2 = 1;
        return Math.log((d2 + d) / (d2 - d)) / 2;
    }

    @SinceKotlin(m5061version = "1.8")
    @InlineOnly
    /* renamed from: cbrt */
    private static final double m6373cbrt(double d) {
        return Math.cbrt(d);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: ceil */
    private static final double m6375ceil(double d) {
        return Math.ceil(d);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: cos */
    private static final double m6377cos(double d) {
        return Math.cos(d);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: cosh */
    private static final double m6379cosh(double d) {
        return Math.cosh(d);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: exp */
    private static final double m6381exp(double d) {
        return Math.exp(d);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: expm1 */
    private static final double m6383expm1(double d) {
        return Math.expm1(d);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: floor */
    private static final double m6385floor(double d) {
        return Math.floor(d);
    }

    private static final double getAbsoluteValue(double d) {
        return Math.abs(d);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(double d) {
    }

    /* renamed from: getSign */
    private static final double m6387getSign(double d) {
        return Math.signum(d);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getSign$annotations(double d) {
    }

    /* renamed from: getUlp */
    private static final double m6391getUlp(double d) {
        return Math.ulp(d);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getUlp$annotations(double d) {
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: hypot */
    private static final double m6393hypot(double d, double d2) {
        return Math.hypot(d, d2);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: ln */
    private static final double m6395ln(double d) {
        return Math.log(d);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: ln1p */
    private static final double m6397ln1p(double d) {
        return Math.log1p(d);
    }

    @SinceKotlin(m5061version = "1.2")
    /* renamed from: log */
    public static final double m6399log(double d, double d2) {
        if (d2 <= 0.0d || d2 == 1.0d) {
            return Double.NaN;
        }
        return Math.log(d) / Math.log(d2);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: log10 */
    private static final double m6401log10(double d) {
        return Math.log10(d);
    }

    @SinceKotlin(m5061version = "1.2")
    /* renamed from: log2 */
    public static final double m6403log2(double d) {
        return Math.log(d) / Constants.LN2;
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: max */
    private static final double m6405max(double d, double d2) {
        return Math.max(d, d2);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: min */
    private static final double m6409min(double d, double d2) {
        return Math.min(d, d2);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final double nextDown(double d) {
        return Math.nextAfter(d, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final double nextTowards(double d, double d2) {
        return Math.nextAfter(d, d2);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: nextUp */
    private static final double m6413nextUp(double d) {
        return Math.nextUp(d);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: pow */
    private static final double m6415pow(double d, double d2) {
        return Math.pow(d, d2);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: round */
    private static final double m6419round(double d) {
        return Math.rint(d);
    }

    @SinceKotlin(m5061version = "1.2")
    public static int roundToInt(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d);
    }

    @SinceKotlin(m5061version = "1.2")
    public static long roundToLong(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: sign */
    private static final double m6421sign(double d) {
        return Math.signum(d);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: sin */
    private static final double m6423sin(double d) {
        return Math.sin(d);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: sinh */
    private static final double m6425sinh(double d) {
        return Math.sinh(d);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: sqrt */
    private static final double m6427sqrt(double d) {
        return Math.sqrt(d);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: tan */
    private static final double m6429tan(double d) {
        return Math.tan(d);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: tanh */
    private static final double m6431tanh(double d) {
        return Math.tanh(d);
    }

    @SinceKotlin(m5061version = "1.2")
    public static final double truncate(double d) {
        return (Double.isNaN(d) || Double.isInfinite(d)) ? d : d > 0.0d ? Math.floor(d) : Math.ceil(d);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final double withSign(double d, double d2) {
        return Math.copySign(d, d2);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: IEEErem */
    private static final float m6354IEEErem(float f, float f2) {
        return (float) Math.IEEEremainder(f, f2);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: abs */
    private static final float m6356abs(float f) {
        return Math.abs(f);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: acos */
    private static final float m6360acos(float f) {
        return (float) Math.acos(f);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: asin */
    private static final float m6364asin(float f) {
        return (float) Math.asin(f);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: atan */
    private static final float m6368atan(float f) {
        return (float) Math.atan(f);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: atan2 */
    private static final float m6370atan2(float f, float f2) {
        return (float) Math.atan2(f, f2);
    }

    @SinceKotlin(m5061version = "1.8")
    @InlineOnly
    /* renamed from: cbrt */
    private static final float m6374cbrt(float f) {
        return (float) Math.cbrt(f);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: ceil */
    private static final float m6376ceil(float f) {
        return (float) Math.ceil(f);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: cos */
    private static final float m6378cos(float f) {
        return (float) Math.cos(f);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: cosh */
    private static final float m6380cosh(float f) {
        return (float) Math.cosh(f);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: exp */
    private static final float m6382exp(float f) {
        return (float) Math.exp(f);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: expm1 */
    private static final float m6384expm1(float f) {
        return (float) Math.expm1(f);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: floor */
    private static final float m6386floor(float f) {
        return (float) Math.floor(f);
    }

    private static final float getAbsoluteValue(float f) {
        return Math.abs(f);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(float f) {
    }

    /* renamed from: getSign */
    private static final float m6388getSign(float f) {
        return Math.signum(f);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getSign$annotations(float f) {
    }

    /* renamed from: getUlp */
    private static final float m6392getUlp(float f) {
        return Math.ulp(f);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getUlp$annotations(float f) {
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: hypot */
    private static final float m6394hypot(float f, float f2) {
        return (float) Math.hypot(f, f2);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: ln */
    private static final float m6396ln(float f) {
        return (float) Math.log(f);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: ln1p */
    private static final float m6398ln1p(float f) {
        return (float) Math.log1p(f);
    }

    @SinceKotlin(m5061version = "1.2")
    /* renamed from: log */
    public static final float m6400log(float f, float f2) {
        if (f2 <= 0.0f || f2 == 1.0f) {
            return Float.NaN;
        }
        return (float) (Math.log(f) / Math.log(f2));
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: log10 */
    private static final float m6402log10(float f) {
        return (float) Math.log10(f);
    }

    @SinceKotlin(m5061version = "1.2")
    /* renamed from: log2 */
    public static final float m6404log2(float f) {
        return (float) (Math.log(f) / Constants.LN2);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: max */
    private static final float m6406max(float f, float f2) {
        return Math.max(f, f2);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: min */
    private static final float m6410min(float f, float f2) {
        return Math.min(f, f2);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final float nextDown(float f) {
        return Math.nextAfter(f, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final float nextTowards(float f, float f2) {
        return Math.nextAfter(f, f2);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: nextUp */
    private static final float m6414nextUp(float f) {
        return Math.nextUp(f);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: pow */
    private static final double m6416pow(double d, int i) {
        return Math.pow(d, i);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: round */
    private static final float m6420round(float f) {
        return (float) Math.rint(f);
    }

    @SinceKotlin(m5061version = "1.2")
    public static final long roundToLong(float f) {
        return C1237MathKt.roundToLong(f);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: sign */
    private static final float m6422sign(float f) {
        return Math.signum(f);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: sin */
    private static final float m6424sin(float f) {
        return (float) Math.sin(f);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: sinh */
    private static final float m6426sinh(float f) {
        return (float) Math.sinh(f);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: sqrt */
    private static final float m6428sqrt(float f) {
        return (float) Math.sqrt(f);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: tan */
    private static final float m6430tan(float f) {
        return (float) Math.tan(f);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: tanh */
    private static final float m6432tanh(float f) {
        return (float) Math.tanh(f);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final double withSign(double d, int i) {
        return Math.copySign(d, i);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: abs */
    private static final int m6357abs(int i) {
        return Math.abs(i);
    }

    private static final int getAbsoluteValue(int i) {
        return Math.abs(i);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(int i) {
    }

    /* renamed from: getSign */
    public static int m6389getSign(int i) {
        return Integer.signum(i);
    }

    @SinceKotlin(m5061version = "1.2")
    public static /* synthetic */ void getSign$annotations(int i) {
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: max */
    private static final int m6407max(int i, int i2) {
        return Math.max(i, i2);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: min */
    private static final int m6411min(int i, int i2) {
        return Math.min(i, i2);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: pow */
    private static final float m6417pow(float f, float f2) {
        return (float) Math.pow(f, f2);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final float withSign(float f, float f2) {
        return Math.copySign(f, f2);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: abs */
    private static final long m6358abs(long j) {
        return Math.abs(j);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: atanh */
    private static final float m6372atanh(float f) {
        return (float) m6371atanh(f);
    }

    private static final long getAbsoluteValue(long j) {
        return Math.abs(j);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(long j) {
    }

    /* renamed from: getSign */
    public static int m6390getSign(long j) {
        return Long.signum(j);
    }

    @SinceKotlin(m5061version = "1.2")
    public static /* synthetic */ void getSign$annotations(long j) {
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: max */
    private static final long m6408max(long j, long j2) {
        return Math.max(j, j2);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: min */
    private static final long m6412min(long j, long j2) {
        return Math.min(j, j2);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: pow */
    private static final float m6418pow(float f, int i) {
        return (float) Math.pow(f, i);
    }

    @SinceKotlin(m5061version = "1.2")
    public static final int roundToInt(float f) {
        if (Float.isNaN(f)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f);
    }

    @SinceKotlin(m5061version = "1.2")
    public static final float truncate(float f) {
        double dCeil;
        if (Float.isNaN(f) || Float.isInfinite(f)) {
            return f;
        }
        if (f > 0.0f) {
            dCeil = Math.floor(f);
        } else {
            dCeil = Math.ceil(f);
        }
        return (float) dCeil;
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final float withSign(float f, int i) {
        return Math.copySign(f, i);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: acosh */
    private static final float m6362acosh(float f) {
        return (float) m6361acosh(f);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: asinh */
    private static final float m6366asinh(float f) {
        return (float) m6365asinh(f);
    }
}
