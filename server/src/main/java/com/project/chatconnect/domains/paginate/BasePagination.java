package com.project.chatconnect.domains.paginate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public class BasePagination<E, R extends MongoRepository<E, ?>> {
    private R repository;

    public BasePagination() {

    }

    public BasePagination(R repository) {
        this.repository = repository;
    }

    public PaginationDTO<E> paginate(Integer page, Integer perPage) {
        page = page == null ? 0 : page;
        perPage = perPage == null ? 10 : perPage;
        Page<E> pageData = this.repository.findAll(PageRequest.of(page, perPage));
        Pagination pagination = new Pagination(page, perPage, pageData.getTotalPages() - 1, pageData.getTotalElements());
        return new PaginationDTO<>(this.repository.findAll(), pagination);
    }

    public PaginationDTO<E> paginate(Integer page, Integer perPage, Page<E> pageData) {
        Pagination pagination = new Pagination(page, perPage, pageData.getTotalPages() - 1, pageData.getTotalElements());
        return new PaginationDTO<>(pageData.getContent(), pagination);
    }
}
