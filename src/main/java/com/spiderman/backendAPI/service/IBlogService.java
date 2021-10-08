package com.spiderman.backendAPI.service;

import com.spiderman.backendAPI.exception.IBlogNotFoundException;
import com.spiderman.backendAPI.model.IBlog;
import com.spiderman.backendAPI.repo.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class IBlogService {
    private final IBlogRepo iIBlogRepo;

    @Autowired
    public IBlogService(IBlogRepo iIBlogRepo) {
        this.iIBlogRepo = iIBlogRepo;
    }

    public IBlog addIBlog(IBlog iIBlog) {
        return iIBlogRepo.save(iIBlog);
    }

    public List<IBlog> findAllIBlogs() {
        return iIBlogRepo.findAll();
    }

    public IBlog updateIBlog(IBlog iIBlog) {
        return iIBlogRepo.save(iIBlog);
    }

    public IBlog findIBlogById(Long id) {
        return iIBlogRepo.findIBlogById(id)
                .orElseThrow(() -> new IBlogNotFoundException("IBlog by id " + id + " was not found"));
    }

    @Transactional
    public void deleteIBlog(Long id){
        iIBlogRepo.deleteIBlogById(id);
    }
}