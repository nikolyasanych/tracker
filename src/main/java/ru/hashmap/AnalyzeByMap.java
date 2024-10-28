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
        int count = 0;
        int subCount = 0;
        double result;
        String name;
        List<Label> labelList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            name = pupil.name();
            for (Subject subject : pupil.subjects()) {
                subCount += subject.score();
                count++;
            }
            result = (double) subCount / count;
            Label label = new Label(name, result);
            labelList.add(label);
            subCount = 0;
            count = 0;
        }
        return labelList;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        String name;
        int score;
        int count = 0;
        List<Label> labelList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            count++;
            for (Subject subject : pupil.subjects()) {
                name = subject.name();
                score = subject.score();
                if (map.get(name) != null) {
                    score += map.get(name);
                }
                map.put(name, score);
            }
        }
        for (String key : map.keySet()) {
            Label label = new Label(key, (double) map.get(key) / count);
            labelList.add(label);
        }
        return labelList;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        int score = 0;
        String name;
        List<Label> labelList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            name = pupil.name();
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            Label label = new Label(name, score);
            labelList.add(label);
            score = 0;
        }
        labelList.sort(Comparator.naturalOrder());
        return labelList.get(labelList.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        String name;
        int score;
        List<Label> labelList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                name = subject.name();
                score = subject.score();
                if (map.get(name) != null) {
                    score += map.get(name);
                }
                map.put(name, score);
            }
        }
        for (String key : map.keySet()) {
            Label label = new Label(key, map.get(key));
            labelList.add(label);
        }
        labelList.sort(Comparator.naturalOrder());
        return labelList.get(labelList.size() - 1);
    }
}
