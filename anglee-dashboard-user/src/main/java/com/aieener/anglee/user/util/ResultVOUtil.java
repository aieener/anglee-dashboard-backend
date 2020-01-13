package com.aieener.anglee.user.util;

import com.aieener.anglee.user.enums.ResultEnum;
import com.aieener.anglee.user.vo.ResultVO;

public class ResultVOUtil {
    public static <T> ResultVO<T> success(T object) {
        ResultVO<T> resultVO = new ResultVO<T>();
        resultVO.setData(object);
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMsg("Success");
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(ResultEnum resultEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg(resultEnum.getMsg());
        resultVO.setCode(resultEnum.getCode());
        return resultVO;
    }
}
