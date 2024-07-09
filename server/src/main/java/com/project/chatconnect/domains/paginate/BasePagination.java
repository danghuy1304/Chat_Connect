package com.project.chatconnect.domains.paginate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * The type Base pagination.
 *
 * @param <E> the type parameter
 * @param <R> the type parameter
 * @author Huy Dang
 */
@Component
public class BasePagination<E, R extends MongoRepository<E, ?>> {
    private R repository;

    /**
     * Constructor no parameter.
     */
    public BasePagination() {
    }

    /**
     * Constructor has parameter.
     *
     * @param repository the repository
     */
    @Autowired
    public BasePagination(R repository) {
        this.repository = repository;
    }

    /**
     * Paginate pagination dto has a repository.
     *
     * @param page    the page
     * @param perPage the per page
     * @return the pagination dto
     */
    public PaginationDTO<E> paginate(Integer page, Integer perPage) {
        page = page == null ? 0 : page;
        perPage = perPage == null ? 10 : perPage;
        Page<E> pageData = this.repository.findAll(PageRequest.of(page, perPage));
        Pagination pagination = new Pagination(page, perPage, pageData.getTotalPages() - 1, pageData.getTotalElements());
        return new PaginationDTO<>(this.repository.findAll(), pagination);
    }

    /**
     * Paginate pagination dto no repository.
     *
     * @param page     the page
     * @param perPage  the per page
     * @param pageData the page data
     * @return the pagination dto
     */
    public PaginationDTO<E> paginate(Integer page, Integer perPage, Page<E> pageData) {
        Pagination pagination = new Pagination(page, perPage, pageData.getTotalPages() - 1, pageData.getTotalElements());
        return new PaginationDTO<>(pageData.getContent(), pagination);
    }
}
