/**
 * Copyright 2016 GwynnieBee Inc.
 */

package com.nitrkl.timetable.utils;

/**
 * The data provider that we use in our application.
 *
 * @author eswar
 * @version 1.00
 * @since 15/11/2016
 */
public class DataProvider {

    public static final String STUDENT_TIME_TABLE = "[\n" +
            "\t\t{ \"name\": \"OE\", \"dayOfWeek\": 2, \"startTime\": \"11:00\", \"endTime\": \"12:00\", \"color\": \"#59dbe0\", \"courseId\": \"c_03_001\" },\n" +
            "\t\t{ \"name\": \"thermal\", \"dayOfWeek\": 2, \"startTime\": \"14:15\", \"endTime\": \"15:15\", \"color\": \"#F57F68\", \"courseId\": \"c_03_002\" },\n" +
            "\t\t{ \"name\": \"EC\", \"dayOfWeek\": 2, \"startTime\": \"15:15\", \"endTime\": \"16:15\", \"color\": \"#87d288\", \"courseId\": \"c_03_003\" },\n" +
            "\t\t{ \"name\": \"GSM\", \"dayOfWeek\": 2, \"startTime\": \"16:15\", \"endTime\": \"17:15\", \"color\": \"#f8b552\", \"courseId\": \"c_03_004\" },\n" +
            "\n" +
            "\t\t{ \"name\": \"OE\", \"dayOfWeek\": 3, \"startTime\": \"11:00\", \"endTime\": \"12:00\", \"color\": \"#59dbe0\", \"courseId\": \"c_03_001\" },\n" +
            "\t\t{ \"name\": \"EC\", \"dayOfWeek\": 3, \"startTime\": \"14:15\", \"endTime\": \"15:15\", \"color\": \"#F57F68\", \"courseId\": \"c_03_003\" },\n" +
            "\t\t{ \"name\": \"Ergonomics\", \"dayOfWeek\": 3, \"startTime\": \"15:15\", \"endTime\": \"16:15\", \"color\": \"#87d288\", \"courseId\": \"c_03_005\" },\n" +
            "\t\t{ \"name\": \"GSM\", \"dayOfWeek\": 3, \"startTime\": \"16:15\", \"endTime\": \"17:15\", \"color\": \"#f8b552\", \"courseId\": \"c_03_004\" },\n" +
            "\n" +
            "\t\t{ \"name\": \"thermal\", \"dayOfWeek\": 4, \"startTime\": \"10:00\", \"endTime\": \"11:00\", \"color\": \"#59dbe0\", \"courseId\": \"c_03_002\" },\n" +
            "\t\t{ \"name\": \"EC\", \"dayOfWeek\": 4, \"startTime\": \"11:00\", \"endTime\": \"12:00\", \"color\": \"#F57F68\", \"courseId\": \"c_03_003\" },\n" +
            "\t\t{ \"name\": \"Ansys Lab\", \"dayOfWeek\": 4, \"startTime\": \"14:15\", \"endTime\": \"17:15\", \"color\": \"#87d288\", \"courseId\": \"c_03_008\" },\n" +
            "\n" +
            "\t\t{ \"name\": \"Ergonomics Lab\", \"dayOfWeek\": 5, \"startTime\": \"8:00\", \"endTime\": \"11:00\", \"color\": \"#59dbe0\", \"courseId\": \"c_03_006\" },\n" +
            "\t\t{ \"name\": \"EC\", \"dayOfWeek\": 5, \"startTime\": \"13:15\", \"endTime\": \"14:15\", \"color\": \"#F57F68\", \"courseId\": \"c_03_003\" },\n" +
            "\t\t{ \"name\": \"Ergonomics\", \"dayOfWeek\": 5, \"startTime\": \"14:15\", \"endTime\": \"15:15\", \"color\": \"#87d288\", \"courseId\": \"c_03_005\" },\n" +
            "\t\t{ \"name\": \"GSM\", \"dayOfWeek\": 5, \"startTime\": \"16:15\", \"endTime\": \"17:15\", \"color\": \"#f8b552\", \"courseId\": \"c_03_004\" },\n" +
            "\n" +
            "\t\t{ \"name\": \"Product devlopment lab\", \"dayOfWeek\": 6, \"startTime\": \"8:00\", \"endTime\": \"11:00\", \"color\": \"#59dbe0\", \"courseId\": \"c_03_007\" },\n" +
            "\t\t{ \"name\": \"OE\", \"dayOfWeek\": 6, \"startTime\": \"11:00\", \"endTime\": \"12:00\", \"color\": \"#F57F68\", \"courseId\": \"c_03_001\" },\n" +
            "\t\t{ \"name\": \"Ergonomics\", \"dayOfWeek\": 6, \"startTime\": \"13:15\", \"endTime\": \"14:15\", \"color\": \"#87d288\", \"courseId\": \"c_03_005\" },\n" +
            "\t\t{ \"name\": \"thermal\", \"dayOfWeek\": 6, \"startTime\": \"14:15\", \"endTime\": \"15:15\", \"color\": \"#f8b552\", \"courseId\": \"c_03_002\" },\n" +
            "\t\t{ \"name\": \"GSM\", \"dayOfWeek\": 6, \"startTime\": \"16:15\", \"endTime\": \"17:15\", \"color\": \"#59dbe0\", \"courseId\": \"c_03_004\" }\n" +
            "\t]";

    public static final String TEACHER_TIME_TABLE = "[\n" +
            "\t\t{ \"name\": \"PD Lab 3rd year\", \"dayOfWeek\": 2, \"startTime\": \"8:00\", \"endTime\": \"10:00\", \"color\": \"#59dbe0\", \"courseId\": \"c_03_009\" },\n" +
            "\t\t{ \"name\": \"Mtech\", \"dayOfWeek\": 2, \"startTime\": \"11:00\", \"endTime\": \"12:00\", \"color\": \"#F57F68\", \"courseId\": \"c_05_001\" },\n" +
            "\t\t{ \"name\": \"4th year\", \"dayOfWeek\": 2, \"startTime\": \"15:15\", \"endTime\": \"16:15\", \"color\": \"#87d288\", \"courseId\": \"c_04_001\" },\n" +
            "\t\t{ \"name\": \"GSM 3rd year\", \"dayOfWeek\": 2, \"startTime\": \"16:15\", \"endTime\": \"17:15\", \"color\": \"#f8b552\", \"courseId\": \"c_03_004\" },\n" +
            "\n" +
            "\t\t{ \"name\": \"PD lab 4th year\", \"dayOfWeek\": 3, \"startTime\": \"8:00\", \"endTime\": \"10:00\", \"color\": \"#59dbe0\", \"courseId\": \"c_04_009\" },\n" +
            "\t\t{ \"name\": \"4th year\", \"dayOfWeek\": 3, \"startTime\": \"14:15\", \"endTime\": \"15:15\", \"color\": \"#F57F68\", \"courseId\": \"c_04_001\" },\n" +
            "\t\t{ \"name\": \"GSM 3rd year\", \"dayOfWeek\": 3, \"startTime\": \"16:15\", \"endTime\": \"17:15\", \"color\": \"#87d288\", \"courseId\": \"c_03_004\" },\n" +
            "\n" +
            "\t\t{ \"name\": \"4th year\", \"dayOfWeek\": 4, \"startTime\": \"9:00\", \"endTime\": \"10:00\", \"color\": \"#59dbe0\", \"courseId\": \"c_04_001\" },\n" +
            "\n" +
            "\t\t{ \"name\": \"4th year\", \"dayOfWeek\": 5, \"startTime\": \"13:15\", \"endTime\": \"14:15\", \"color\": \"#59dbe0\", \"courseId\": \"c_04_001\" },\n" +
            "\t\t{ \"name\": \"Mtech\", \"dayOfWeek\": 5, \"startTime\": \"15:15\", \"endTime\": \"16:15\", \"color\": \"#F57F68\", \"courseId\": \"c_05_001\" },\n" +
            "\t\t{ \"name\": \"GSM 3rd year\", \"dayOfWeek\": 5, \"startTime\": \"16:15\", \"endTime\": \"17:15\", \"color\": \"#87d288\", \"courseId\": \"c_03_004\" },\n" +
            "\n" +
            "\t\t{ \"name\": \"CATIA LAB 2nd year\", \"dayOfWeek\": 6, \"startTime\": \"8:00\", \"endTime\": \"10:00\", \"color\": \"#59dbe0\", \"courseId\": \"c_02_001\" },\n" +
            "\t\t{ \"name\": \"Mtech\", \"dayOfWeek\": 6, \"startTime\": \"14:15\", \"endTime\": \"15:15\", \"color\": \"#F57F68\", \"courseId\": \"c_05_001\" },\n" +
            "\t\t{ \"name\": \"GSM 3rd year\", \"dayOfWeek\": 6, \"startTime\": \"16:15\", \"endTime\": \"17:15\", \"color\": \"#87d288\", \"courseId\": \"c_03_004\" }\n" +
            "\t]";

    private DataProvider() {
    }
}
