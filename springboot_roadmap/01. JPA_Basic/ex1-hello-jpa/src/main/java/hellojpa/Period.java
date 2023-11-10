package hellojpa;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Period {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    // 임베디드 타입을 활용하면 응집성을 높여 관련된 메소드를 만들 수 있다.
    public boolean isWork(LocalDateTime checkDate){
        if (checkDate.isBefore(startDate) || checkDate.isAfter(endDate)){
            // 체크 시간이 출근시간 전이거나 퇴근시간 이후이면 근무 중이 아님
            return false;
        }
        return true;
    }

    public Period() {
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
