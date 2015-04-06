package com.yao.consumer;

import com.yao.model.Message;

/**
 * Created by yaozb on 15-4-6.
 */
public interface NoticeConsume {
    public void onMessage(Message message);
}
