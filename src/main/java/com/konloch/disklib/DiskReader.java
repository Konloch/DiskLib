package com.konloch.disklib;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * Small disk reading util
 *
 * @author Konloch
 * @since Oct 18, 2014
 */
public class DiskReader
{
	/**
	 * Load a file into a String Array from a valid String path
	 *
	 * @param filePath any valid file path to read from
	 * @return String Array with the file content lines
	 * @throws IOException if an I/O error occurs reading from the stream
	 */
	public static String[] readArray(String filePath) throws IOException
	{
		return read(filePath).toArray(new String[0]);
	}
	
	/**
	 * Load a file into a String Array from a File object
	 *
	 * @param file the file object to read from
	 * @return String Array with the file content lines
	 * @throws IOException if an I/O error occurs reading from the stream
	 */
	public static String[] readArray(File file) throws IOException
	{
		return read(file).toArray(new String[0]);
	}
	
	/**
	 * Loads a file into a byte Array from a valid String path
	 *
	 * @param filePath any valid file path to read from
	 * @return byte Array with the file content lines
	 * @throws IOException if an I/O error occurs reading from the stream
	 */
	public static byte[] readBytes(String filePath) throws IOException
	{
		return readBytes(new File(filePath));
	}
	
	/**
	 * Loads a file into a byte Array from a File object
	 *
	 * @param file the file object to read from
	 * @return byte Array with the file content lines
	 * @throws IOException if an I/O error occurs reading from the stream
	 */
	public static byte[] readBytes(File file) throws IOException
	{
		return Files.readAllBytes(file.toPath());
	}
	
	/**
	 * Loads a file into a byte Array from a valid String path
	 *
	 * @param filePath any valid file path to read from
	 * @return String with the file content lines
	 * @throws IOException if an I/O error occurs reading from the stream
	 */
	public static String readString(String filePath) throws IOException
	{
		return readString(new File(filePath));
	}
	
	/**
	 * Loads a file into a String from a File object
	 *
	 * @param file the file object to read from
	 * @return String with the file content lines
	 * @throws IOException if an I/O error occurs reading from the stream
	 */
	public static String readString(File file) throws IOException
	{
		return new String(readBytes(file), StandardCharsets.UTF_8);
	}
	
	/**
	 * Loads a file into a String ArrayList from a valid String path
	 *
	 * @param filePath any valid file path to read from
	 * @return String ArrayList with the file content lines
	 * @throws IOException if an I/O error occurs reading from the stream
	 */
	public static ArrayList<String> read(String filePath) throws IOException
	{
		return read(new File(filePath));
	}
	
	/**
	 * Loads a file into a String ArrayList from a File object
	 *
	 * @param file the file object to read from
	 * @return String ArrayList with the file content lines
	 * @throws IOException if an I/O error occurs reading from the stream
	 */
	public static ArrayList<String> read(File file) throws IOException
	{
		ArrayList<String> array = new ArrayList<>();
		
		String fullString = readString(file);
		
		BufferedReader reader = null;
		try
		{
			reader = new BufferedReader(new StringReader(fullString));
			String add;
			
			while ((add = reader.readLine()) != null)
			{
				array.add(add);
			}
		}
		catch (IOException e)
		{
			throw e;
		}
		finally
		{
			if (reader != null)
				try
				{
					reader.close();
				} catch (Exception ex) {}
		}
		
		return array;
	}
	
	/**
	 * Alert that this is a library
	 *
	 * @param args program launch arguments
	 */
	public static void main(String[] args)
	{
		throw new RuntimeException("Incorrect usage - for information on how to use this correctly visit https://konloch.com/DiskLib/");
	}
}