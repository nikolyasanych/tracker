package ru.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        int result = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                result += subject.score();
                count++;
            }
        }
        return (double) result / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int subjectScore = 0;
            List<Subject> subjectList = pupil.subjects();
            for (Subject subject : subjectList) {
                subjectScore += subject.score();
            }
            double averageScore = (double) subjectScore / subjectList.size();
            labelList.add(new Label(pupil.name(), averageScore));
        }
        return labelList;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = getSubjectScore(pupils);
        List<Label> labelList = new ArrayList<>();
        for (String key : map.keySet()) {
            double result = (double) map.get(key) / pupils.size();
            labelList.add(new Label(key, result));
        }
        return labelList;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            labelList.add(new Label(pupil.name(), score));
        }
        labelList.sort(Comparator.naturalOrder());
        return labelList.get(labelList.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = getSubjectScore(pupils);
        List<Label> labelList = new ArrayList<>();
        for (String key : map.keySet()) {
            labelList.add(new Label(key, map.get(key)));
        }
        labelList.sort(Comparator.naturalOrder());
        return labelList.get(labelList.size() - 1);
    }

    private static Map<String, Integer> getSubjectScore(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String name = subject.name();
                int score = subject.score();
                score += map.getOrDefault(name, 0);
                map.put(name, score);
            }
        }
        return map;
    }
}
