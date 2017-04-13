package com.wma.ozfoodhunter.apimodule;


public interface ResponseHandle {

    void onComplete(String response, String action, Exception e);
}
