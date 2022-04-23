package com.example.roomexample.adapters;

import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomexample.R;
import com.example.roomexample.callback.EmployeeDeleteListener;
import com.example.roomexample.callback.EmployeeEditListener;
import com.example.roomexample.databinding.EmployeeRowBinding;
import com.example.roomexample.entities.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private EmployeeRowBinding binding;
    private List<Employee> employeeList;
    private EmployeeDeleteListener deleteListener;
    private EmployeeEditListener editListener;

    public EmployeeAdapter(Fragment fragment) {

        this.employeeList = new ArrayList<>();
        editListener = (EmployeeEditListener) fragment;
        deleteListener = (EmployeeDeleteListener) fragment;
    }


    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = EmployeeRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new EmployeeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        final Employee employee = employeeList.get(position);
        holder.bind(employee);

    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public void submitNewList(List<Employee> employeeList) {
        this.employeeList = employeeList;
        notifyDataSetChanged();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        EmployeeRowBinding binding;

        public EmployeeViewHolder(EmployeeRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.rowMenuBtn.setOnClickListener(view -> {

                final int position = getAdapterPosition();
                final Employee employee = employeeList.get(position);

                PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                menuInflater.inflate(R.menu.row_employee_menu, popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(menuItem -> {
                    switch (menuItem.getItemId()) {
                        case R.id.item_edit:
                            editListener.onEditEmployee(employee);
                            return true;
                        case R.id.item_delete:
                            deleteListener.onDeleteListener(employee);
                            return true;
                    }
                    return false;
                });

            });

        }

        public void bind(Employee employee) {

            binding.setEmployee(employee);

        }

    }
}
