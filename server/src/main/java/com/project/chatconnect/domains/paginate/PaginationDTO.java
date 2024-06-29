package com.project.chatconnect.domains.paginate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaginationDTO<DTO> {
    private List<DTO> data;

    private Pagination pagination;
}
