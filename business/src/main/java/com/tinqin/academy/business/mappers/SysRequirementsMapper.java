package com.tinqin.academy.business.mappers;

import com.tinqin.academy.business.dtos.SystemRequirementsDto;
import com.tinqin.academy.data.models.SystemRequirements;

public class SysRequirementsMapper {

    public static SystemRequirements dtoToSysReq(SystemRequirementsDto dto) {
        SystemRequirements sysReq = new SystemRequirements();
        sysReq.setCpu(dto.getCpu());
        return sysReq;
    }

    public static SystemRequirements dtoToSysReq(SystemRequirementsDto dto, long id) {
        SystemRequirements sysReq = dtoToSysReq(dto);
        sysReq.setSystemRequirementsId(id);
        return sysReq;
    }

    public static SystemRequirementsDto sysReqToDto(SystemRequirements sysReq) {
        return new SystemRequirementsDto(sysReq.getCpu());
    }
}
