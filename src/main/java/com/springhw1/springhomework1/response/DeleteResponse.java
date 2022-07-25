package com.springhw1.springhomework1.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteResponse<T> extends CommonResponse {
   Boolean data;
}
