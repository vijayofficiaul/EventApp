package com.example.myproject1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.MyViewHolder1> {

    List<EmployeeModel> employee;
    Context context;
    dbhelper2 db;

    public MyAdapter1(List<EmployeeModel> employee, Context context) {
        this.employee = employee;
        this.context = context;
        db = new dbhelper2(context);

    }

    @NonNull
    @Override
    public MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.employee_list,parent,false);
        MyViewHolder1 viewHolder = new MyViewHolder1(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder1 holder, @SuppressLint("RecyclerView") int position) {
        final EmployeeModel employeeModel = employee.get(position);
        holder.empid1.setText(Integer.toString(employeeModel.getId()));
        holder.name.setText(employeeModel.getNameS());
        holder.email.setText(employeeModel.getEmailS());
        holder.number.setText(employeeModel.getMobilenemberS());
        holder.password.setText(employeeModel.getPasswordS());
        holder.address.setText(employeeModel.getAddressS());
        holder.pincode.setText(employeeModel.getPincodeS());
        holder.gender.setText(employeeModel.getGenderS());

        holder.edit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stringName = holder.name.getText().toString();
                String stringEmail = holder.email.getText().toString();
                String stringNumber = holder.number.getText().toString();
                String stringPassword = holder.password.getText().toString();
                String stringAddress = holder.address.getText().toString();
                String stringPincode = holder.pincode.getText().toString();
                String stringGender = holder.gender.getText().toString();

                db.updateEmployee(new EmployeeModel(employeeModel.getId(),stringName, stringEmail,stringNumber,stringPassword,stringAddress,stringPincode,stringGender));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });

        holder.delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteEmployee((employeeModel.getId()));
                employee.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return employee.size();
    }
    public class MyViewHolder1 extends RecyclerView.ViewHolder
    {
        EditText name,email,number,password,address,pincode,empid1,gender;
        Button edit1,delete1;
        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
            empid1=itemView.findViewById(R.id.empid1);
            name=itemView.findViewById(R.id.name);
            email=itemView.findViewById(R.id.notifcontent);
            number=itemView.findViewById(R.id.number);
            password=itemView.findViewById(R.id.password1);
            address=itemView.findViewById(R.id.address);
            pincode=itemView.findViewById(R.id.pincode);
            edit1=itemView.findViewById(R.id.edit1);
            delete1=itemView.findViewById(R.id.delete1);
            gender=itemView.findViewById(R.id.gender);
        }
    }
}

