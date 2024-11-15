package com.project.chatconnect.domains.paginate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * The type Pagination dto.
 *
 * @param <DTO> the type parameter
 * @author Huy Dang
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaginationDTO<DTO> {
    private List<DTO> data;

    private Pagination pagination;
}
