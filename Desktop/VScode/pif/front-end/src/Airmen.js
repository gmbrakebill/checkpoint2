import React from 'react';

function Airmen(props)
{
    return(
        <div className = "Airmen">
            <p>ID: {props.id}- {props.rank} {props.first_name} {props.last_name}</p>
    
        </div>
    )
}
export default Airmen;