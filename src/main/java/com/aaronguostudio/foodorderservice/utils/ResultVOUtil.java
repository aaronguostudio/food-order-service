package com.aaronguostudio.foodorderservice.utils;

import com.aaronguostudio.foodorderservice.vo.ResultVO;

public class ResultVOUtil {

  public static ResultVO success(Object object) {
    ResultVO resultVO = new ResultVO();
    resultVO.setCode(0);
    resultVO.setMessage("Success");
    resultVO.setData(object);
    return  resultVO;
  }

  public static ResultVO success() {
    return success(null);
  }

  public static ResultVO error(Integer code, String message) {
    ResultVO resultVO = new ResultVO();
    resultVO.setCode(code);
    resultVO.setMessage(message);
    return  resultVO;
  }
}


