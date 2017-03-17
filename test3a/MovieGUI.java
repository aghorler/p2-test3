/* Aaron Horler - s3481341 */

package test3a;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

@SuppressWarnings("serial")
public class MovieGUI extends JFrame implements ActionListener{
	//ArrayLists
	private ArrayList<Actor> actors;
	private ArrayList<Movie> movies;
	
	//GUI components
	private JTabbedPane tabs;
	private JPanel pnlActor, pnlActorInput, pnlActorDisplay, pnlActorButtons, pnlMovie, pnlMovieInput, pnlMovieDisplay, pnlMovieButtons, pnlDisplay, pnlDisplayDisplay, pnlDisplayButtons;
	
	//Actor panel
	private JLabel lblActorFirstName, lblActorLastName;
	private JTextField txtActorFirstName, txtActorLastName;
	private JList<Actor> listActors;
	private DefaultListModel<Actor> modelActors;
	private JScrollPane scrollActors;
	private JButton btnAddActor, btnDisplayActors;
	
	//Movie panel
	private JLabel lblMovieTitle, lblMovieDirector, lblMovieYear;
	private JTextField txtMovieTitle, txtMovieDirector, txtMovieYear;
	private JList<Actor> listSelectActors;
	private DefaultListModel<Actor> modelSelectActors;
	private JScrollPane scrollSelectActors;
	private JButton btnAddMovie, btnDisplayActorsForSelection;
	
	//Display panel
	private JList<Movie> listMovies;
	private DefaultListModel<Movie> modelMovies;
	private JScrollPane scrollMovies;
	private JButton btnDisplayMovies;
	
	//Constructor
	public MovieGUI(){
		super("Movie GUI");
		actors = new ArrayList<Actor>();
		movies = new ArrayList<Movie>();
		
		//tabs
		tabs = new JTabbedPane();
		add(tabs);
		pnlActor = new JPanel();
		pnlActor.setLayout(new BorderLayout());
		tabs.addTab("Add Actor", pnlActor);
		pnlMovie = new JPanel();
		pnlMovie.setLayout(new BorderLayout());
		tabs.addTab("Add Movie", pnlMovie);
		pnlDisplay = new JPanel();
		pnlDisplay.setLayout(new BorderLayout());
		tabs.addTab("Show Movies", pnlDisplay);
		
		//Actor input panel
		pnlActorInput = new JPanel();
		pnlActorInput.setLayout(new GridLayout(3, 1, 10, 10));
		lblActorFirstName = new JLabel("First name: ");
		lblActorLastName = new JLabel("Last name: ");
		txtActorFirstName = new JTextField(30);
		txtActorLastName = new JTextField(30);
		pnlActorInput.add(lblActorFirstName);
		pnlActorInput.add(txtActorFirstName);
		pnlActorInput.add(lblActorLastName);
		pnlActorInput.add(txtActorLastName);
		pnlActor.add(pnlActorInput, BorderLayout.NORTH);
		
		//Actor display panel
		pnlActorDisplay = new JPanel();
		modelActors = new DefaultListModel<Actor>();
		listActors = new JList<Actor>(modelActors);
		listActors.setBorder(new TitledBorder("Actor/s to select"));
		scrollActors = new JScrollPane(listActors);
		scrollActors.setPreferredSize(new Dimension(475, 365));
		pnlActorDisplay.add(scrollActors);
		pnlActor.add(pnlActorDisplay, BorderLayout.CENTER);
		
		//Actor button panel
		pnlActorButtons = new JPanel();
		btnAddActor = new JButton("Add Actor");
		btnDisplayActors = new JButton("Display Actors");
		pnlActorButtons.add(btnAddActor);
		pnlActorButtons.add(btnDisplayActors);
		pnlActor.add(pnlActorButtons, BorderLayout.SOUTH);
		btnAddActor.addActionListener(this);
		btnDisplayActors.addActionListener(this);
		
		//Movie input panel
		pnlMovieInput = new JPanel();
		pnlMovieInput.setLayout(new GridLayout(3, 1, 10, 10));
		lblMovieTitle = new JLabel("Title: ");
		lblMovieDirector = new JLabel("Director: ");
		lblMovieYear = new JLabel("Year: ");
		txtMovieTitle = new JTextField(30);
		txtMovieDirector = new JTextField(30);
		txtMovieYear = new JTextField(30);
		pnlMovieInput.add(lblMovieTitle);
		pnlMovieInput.add(txtMovieTitle);
		pnlMovieInput.add(lblMovieDirector);
		pnlMovieInput.add(txtMovieDirector);
		pnlMovieInput.add(lblMovieYear);
		pnlMovieInput.add(txtMovieYear);
		pnlMovie.add(pnlMovieInput, BorderLayout.NORTH);
		
		//Movie display panel
		pnlMovieDisplay = new JPanel();
		modelSelectActors = new DefaultListModel<Actor>();
		listSelectActors = new JList<Actor>(modelSelectActors);
		listSelectActors.setBorder(new TitledBorder("Select cast"));
		scrollSelectActors = new JScrollPane(listSelectActors);
		scrollSelectActors.setPreferredSize(new Dimension(475, 365));
		pnlMovieDisplay.add(scrollSelectActors);
		pnlMovie.add(pnlMovieDisplay, BorderLayout.CENTER);
		
		//Movie button panel
		pnlMovieButtons = new JPanel();
		btnDisplayActorsForSelection = new JButton("Display Actors");
		btnAddMovie = new JButton("Add Movie");
		pnlMovieButtons.add(btnDisplayActorsForSelection);
		pnlMovieButtons.add(btnAddMovie);
		pnlMovie.add(pnlMovieButtons, BorderLayout.SOUTH);
		btnDisplayActorsForSelection.addActionListener(this);
		btnAddMovie.addActionListener(this);
		
		//Display display panel
		pnlDisplayDisplay = new JPanel();
		modelMovies = new DefaultListModel<Movie>();
		listMovies = new JList<Movie>(modelMovies);
		listMovies.setBorder(new TitledBorder("All Movies"));
		scrollMovies = new JScrollPane(listMovies);
		scrollMovies.setPreferredSize(new Dimension(475, 450));
		pnlDisplayDisplay.add(scrollMovies);
		pnlDisplay.add(pnlDisplayDisplay, BorderLayout.NORTH);
		
		//Display buttons panel
		pnlDisplayButtons = new JPanel();
		btnDisplayMovies = new JButton("Show all");
		pnlDisplayButtons.add(btnDisplayMovies);
		pnlDisplay.add(pnlDisplayButtons, BorderLayout.SOUTH);
		btnDisplayMovies.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btnAddActor){
			try{
				String firstName = txtActorFirstName.getText();
				String lastName = txtActorLastName.getText();
				
				Actor ac = new Actor(firstName, lastName);
				actors.add(ac);
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(new JFrame(), ex, "Input Error", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(e.getSource() == btnDisplayActors){
			modelActors.clear();
			for(Actor a: actors){
				modelActors.addElement(a);
			}
		}
		else if(e.getSource() == btnDisplayActorsForSelection){
			modelSelectActors.clear();
			for(Actor a: actors){
				modelSelectActors.addElement(a);
			}
		}
		else if(e.getSource() == btnAddMovie){
			try{
				String title = txtMovieTitle.getText();
				String director = txtMovieDirector.getText();
				int year = Integer.parseInt(txtMovieYear.getText());
				Collection<Actor> selected = listSelectActors.getSelectedValuesList();
				
				Movie mo = new Movie(title, director, year, selected);
				movies.add(mo);
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(new JFrame(), ex, "Input Error", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(e.getSource() == btnDisplayMovies){
			modelMovies.clear();
			for(Movie m: movies){
				modelMovies.addElement(m);
			}
		}
	}
	
	public static void main(String[] args){
		MovieGUI fr = new MovieGUI();
		fr.setSize(525, 525);
		fr.setVisible(true);
		fr.setLocationRelativeTo(null);
		fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
