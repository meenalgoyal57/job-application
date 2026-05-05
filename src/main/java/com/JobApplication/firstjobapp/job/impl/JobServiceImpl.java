package com.JobApplication.firstjobapp.job.impl;

import com.JobApplication.firstjobapp.job.Job;
import com.JobApplication.firstjobapp.job.JobRepository;
import com.JobApplication.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    //private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;
    private Long nextId = 1L;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {

        //return jobs;
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
//        jobs.add(job);
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
//        for(Job job:jobs){
//            if(job.getId().equals(id)){
//                return job;
        //}
        //  }
        return jobRepository.findById(id).orElse(null);
        //  return null;
    }

    @Override
    public boolean deleteJobById(Long id) {//(use an iterator bcos it lets you safely modift a collection while iterationg over it)
//        Iterator<Job> iterator = jobs.iterator();
//        while (iterator.hasNext()) {
//            Job job = iterator.next();
//            if (job.getId().equals(id)) {
//                iterator.remove();
//                return true;
//            }
//        }
//        return false;
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
//        for(Job job:jobs){
//            if(job.getId().equals(id)){
//                job.setTitle(updatedJob.getTitle());
//                job.setDescription(updatedJob.getDescription());
//                job.setMinSalary(updatedJob.getMinSalary());
//                job.setMaxSalary(updatedJob.getMaxSalary());
//                job.setLocation(updatedJob.getLocation());
//                return true;
//            }
//        }
//        return false;
//        }
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            return true;
        }
        return false;
    }
}