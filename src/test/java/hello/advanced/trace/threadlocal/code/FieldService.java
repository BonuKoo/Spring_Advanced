package hello.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldService {

    private String nameStore;

    public String logic(String name)  {

        log.info("저장 name={} -> nameStore={}",name,nameStore);
        nameStore = name;
        //저장하고 1초 정도 쉼
        sleep(1000);
        log.info("조회 nameStore={}", nameStore);
        //name을 저장했다가, 1초 정도 기다리고 nameStore를 조회
        return nameStore;
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();;
        }
    }
}
