package org.bouncycastle.p246its;

import java.util.Date;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5969Time32;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5972UINT16;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.Duration;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.ValidityPeriod;

/* loaded from: classes2.dex */
public class ITSValidityPeriod {
    private final C5972UINT16 duration;
    private final long startDate;
    private final EnumC5451Unit timeUnit;

    /* renamed from: org.bouncycastle.its.ITSValidityPeriod$Builder */
    public static class C5450Builder {
        private final long startDate;

        public C5450Builder(Date date) {
            this.startDate = date.getTime();
        }

        public ITSValidityPeriod plusSixtyHours(int i) {
            return new ITSValidityPeriod(this.startDate, C5972UINT16.m17346valueOf(i), EnumC5451Unit.sixtyHours);
        }

        public ITSValidityPeriod plusYears(int i) {
            return new ITSValidityPeriod(this.startDate, C5972UINT16.m17346valueOf(i), EnumC5451Unit.years);
        }
    }

    /* renamed from: org.bouncycastle.its.ITSValidityPeriod$Unit */
    public enum EnumC5451Unit {
        microseconds(0),
        milliseconds(1),
        seconds(2),
        minutes(3),
        hours(4),
        sixtyHours(5),
        years(6);


        /* renamed from: unitTag */
        private final int f21300unitTag;

        EnumC5451Unit(int i) {
            this.f21300unitTag = i;
        }
    }

    public ITSValidityPeriod(long j, C5972UINT16 c5972uint16, EnumC5451Unit enumC5451Unit) {
        this.startDate = j;
        this.duration = c5972uint16;
        this.timeUnit = enumC5451Unit;
    }

    /* renamed from: from */
    public static C5450Builder m16010from(Date date) {
        return new C5450Builder(date);
    }

    public Date getStartDate() {
        return new Date(this.startDate);
    }

    public ValidityPeriod toASN1Structure() {
        return ValidityPeriod.m17347builder().setStart(new C5969Time32(this.startDate / 1000)).setDuration(new Duration(this.timeUnit.f21300unitTag, this.duration)).createValidityPeriod();
    }

    public ITSValidityPeriod(ValidityPeriod validityPeriod) {
        this.startDate = validityPeriod.getStart().getValue().longValue();
        Duration duration = validityPeriod.getDuration();
        this.duration = duration.getDuration();
        this.timeUnit = EnumC5451Unit.m16013values()[duration.getChoice()];
    }
}
