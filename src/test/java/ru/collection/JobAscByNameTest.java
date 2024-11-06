package ru.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    @Test
    void whenJobAscByName() {
        Job job1 = new Job("Nikolay", 1);
        Job job2 = new Job("Ivan", 2);
        Job job3 = new Job("Dmitriy", 3);
        List<Job> jobs = Arrays.asList(job1, job2, job3);
        jobs.sort(new JobAscByName());
        List<Job> expected = Arrays.asList(job3, job2, job1);
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenJobAscByPriority() {
        Job job1 = new Job("Nikolay", 1);
        Job job2 = new Job("Ivan", 2);
        Job job3 = new Job("Dmitriy", 3);
        List<Job> jobs = Arrays.asList(job3, job2, job1);
        jobs.sort(new JobAscByPriority());
        List<Job> expected = Arrays.asList(job1, job2, job3);
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenJobDescByPriority() {
        Job job1 = new Job("Nikolay", 1);
        Job job2 = new Job("Ivan", 2);
        Job job3 = new Job("Dmitriy", 3);
        List<Job> jobs = Arrays.asList(job3, job1, job2);
        jobs.sort(new JobDescByPriority());
        List<Job> expected = Arrays.asList(job3, job2, job1);
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenJobDescByName() {
        Job job1 = new Job("Nikolay", 1);
        Job job2 = new Job("Ivan", 2);
        Job job3 = new Job("Dmitriy", 3);
        List<Job> jobs = Arrays.asList(job3, job1, job2);
        jobs.sort(new JobDescByName());
        List<Job> expected = Arrays.asList(job1, job2, job3);
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenJobAscByPriorityAndName() {
        Comparator<Job> comparator = new JobAscByPriority().thenComparing(new JobAscByName());
        int result = comparator.compare(
                new Job("Nik", 1),
                new Job("Else", 2)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    void whenJobAscByPriorityAndDescName() {
        Comparator<Job> comparator = new JobAscByPriority().thenComparing(new JobDescByName());
        int result = comparator.compare(
                new Job("Nik" , 1),
                new Job("Else", 1)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    void whenJobAscByNameAndPriority() {
        Comparator<Job> comparator = new JobAscByName().thenComparing(new JobAscByPriority());
        int result = comparator.compare(
                new Job("Nik" , 1),
                new Job("Nik", 5)
        );
        assertThat(result).isLessThan(0);
    }
}