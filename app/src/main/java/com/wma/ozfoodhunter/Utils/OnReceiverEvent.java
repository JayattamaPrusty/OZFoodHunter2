package com.wma.ozfoodhunter.Utils;

/**
 * Created by lovekushvishwakarma on 08/12/16.
 */

public class OnReceiverEvent {
    private String itemcount;

    public OnReceiverEvent(String itemcount) {
        this.itemcount = itemcount;
    }

    public String getItemcount() {
        return itemcount;
    }
}
